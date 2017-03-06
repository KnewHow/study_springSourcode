package study.spring;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import study.spring.cfg.BeanConfig;
import study.spring.cfg.PropertyConfig;
import study.spring.factorybean.FactoryBean;
import study.spring.utils.BeanFactoryUtils;

/**
 * This is BeanFactory to create bean by XML file
 * 
 * @author Administrator 2017年2月5日
 */
public class BeanFactory {

    /**
     * This map stores <code>BeanConfig</code> in XML file,the BeanConfig.getId() is as key the
     * BeanConfig is value
     */
    private Map<String, BeanConfig> bcs = new HashMap<String, BeanConfig>();

    /**
     * Bean's cache,if <bean scope="singleton"></bean> if the scope is null or singleton, the bean
     * will be put into this cache the BeanConfig.getId() is as key, the bean is value
     */
    private Map<String, Object> beanCache = new HashMap<String, Object>();

    public BeanFactory(String xmlName) {
        BeanFactoryUtils.load(this, xmlName);
    }

    public void addBeanConfig(BeanConfig beanConfig) {
        this.bcs.put(beanConfig.getId(), beanConfig);
    }
    

    /**
     * This is method is to getBean
     * @param id The unique id to bean
     * @return The new bean
     */
    public Object getBean(String id) {
        BeanConfig bc = this.bcs.get(id);
        if(bc==null){
            throw new RuntimeException("bean"+id+"not exsit");
        }
        if(bc.getScope()==null ||bc.getScope().equalsIgnoreCase("singleton")){
            if(!this.beanCache.containsKey(id)){
                Object bean = createBean(id);
                this.beanCache.put(id, bean);
                return bean;
            }else{
                return this.beanCache.get(id);
            }
        }else{
            return createBean(id);
        }
    }

    /**
     * This method is to create a bean by id
     * 
     * @param id Get <code>BeanConfig</code> from <code>bcs</code> by id
     * @return The new bean created
     */
    private Object createBean(String id) {
        Object bean = null;
        try {
            BeanConfig bc = this.bcs.get(id);
            Class<?> c = Class.forName(bc.getClassName());
            bean = c.newInstance();
            Map<String, PropertyConfig> pcs = bc.getPropertyMap();
            for (String propName : pcs.keySet()) {
                PropertyConfig pc = pcs.get(propName);
                if (pc.getRef() != null) {
                    Object refBean = getBean(pc.getRef());
                    BeanUtils.setProperty(bean, pc.getName(), refBean);
                } else {
                    BeanUtils.setProperty(bean, pc.getName(), pc.getValue());
                }

            }
            if(bean instanceof FactoryBean){
                FactoryBean factoryBean = (FactoryBean) bean;
                return factoryBean.getObject();
            }
        } catch (Exception e) {
            throw new RuntimeException("create bean"+ id+"fail");
        }
        return bean;
    }

    public Map<String, BeanConfig> getBcs() {
        return bcs;
    }

    public void setBcs(Map<String, BeanConfig> bcs) {
        this.bcs = bcs;
    }
    
    

}
