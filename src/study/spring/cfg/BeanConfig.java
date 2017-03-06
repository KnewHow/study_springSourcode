package study.spring.cfg;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This class store <bean> in XML file: <bean id="stu1" className="study.spring.domain.Student"
 * scope="prototype"></bean>
 * 
 * @author Administrator 2017年2月5日
 */
public class BeanConfig {

    /**
     * storing id value, such as "stu1"
     */
    private String id;

    /**
     * storing className, such as "study.spring.domain.Student"
     */
    private String className;

    /**
     * storing scope, such as "prototype",the value of scope only singleton or prototype
     */
    private String scope;

    /**
     * The Map stores <code>PropertyConfig</code>, PropertyConfig.getName as key, PropertyConfig is value
     */
    private Map<String, PropertyConfig> propertyMap = new LinkedHashMap<String, PropertyConfig>();

    public BeanConfig() {
        super();
    }

    public BeanConfig(String id, String className, String scope) {
        super();
        this.id = id;
        this.className = className;
        this.scope = scope;
    }

    public void addPropertyConfig(PropertyConfig propertyConfig) {
        this.propertyMap.put(propertyConfig.getName(), propertyConfig);
    }

    public PropertyConfig getPropertyConfig(String name) {
        return this.propertyMap.get(name);
    }

    public Map<String, PropertyConfig> getPropertyMap() {
        return propertyMap;
    }

    public void setPropertyMap(Map<String, PropertyConfig> propertyMap) {
        this.propertyMap = propertyMap;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        if (!scope.equalsIgnoreCase("singleton") && !scope.equalsIgnoreCase("prototype")) {
            throw new RuntimeException("scope only is singleton or prototype");
        }
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "BeanConfig [id=" + id + ", className=" + className + ", scope=" + scope + "]";
    }

}
