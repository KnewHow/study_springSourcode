package study.spring.factorybean;
/**
 * This FactoryBean interface 
 * @author Administrator
 * 2017年2月6日
 */
public interface FactoryBean {

    /**
     * Get Object
     * @return The Object is itself
     * @throws Exception
     */
    Object getObject() throws Exception;
}
