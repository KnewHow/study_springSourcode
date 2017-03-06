package study.spring.cfg;

/**
 * This class stores  XML file property label：
 *      <property name="number" value="1101"></property>
 *      <property name="teacher" ref="t1"></property>
 * @author Administrator
 * 2017年2月5日
 */
public class PropertyConfig {
    
    /**
     * storing name,example number
     */
    private String name;
    
    /**
     * storing value example 1101
     */
    private String value;
    
    /**
     * storing ref example:t1
     */
    private String ref;

    public PropertyConfig(String name, String value, String ref) {
        super();
        this.name = name;
        this.value = value;
        this.ref = ref;
    }

    public PropertyConfig() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    @Override
    public String toString() {
        return "PropertyConfig [name=" + name + ", value=" + value + ", ref=" + ref + "]";
    }

}
