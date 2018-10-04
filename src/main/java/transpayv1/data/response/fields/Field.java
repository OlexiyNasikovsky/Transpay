/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transpayv1.data.response.fields;

import java.util.List;

/**
 *
 * @author Work
 */
public class Field {
    private String label;
    private String to_send;
    private boolean required;
    //private String type;
    private String parent;
    private String input_type;
    private List<String> values;
    private String data_source;
    private String regular;
   
    
    public Field() {
        super();
    }
    
//    public boolean check(String param) {
//        if(max!=0) {
//            if(param.length()>max) 
//                return false;
//        }
//        if(min!=0) {
//            if(param.length()<min) 
//                return false;
//        }
//        if(mask!=null) {
////            some acions
//        }
//
//        return true;
//    }
    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     * @return 
     */
    public Field setLabel(String label) {
        this.label = label;
        return this;
    }

    /**
     * @return the required
     */
    public boolean isRequired() {
        return required;
    }

    /**
     * @param required the required to set
     * @return 
     */
    public Field setRequired(Integer required) {
        this.required = !required.equals(0);
        return this;
    }

//    /**
//     * @return the type
//     */
//    public String getType() {
//        return type;
//    }
//
//    /**
//     * @param type the type to set
//     * @return 
//     */
//    public Field setType(String type) {
//        this.type = type;
//        return this;
//    }

//    /**
//     * @return the max
//     */
//    public int getMax() {
//        return max;
//    }
//
//    /**
//     * @param max the max to set
//     * @return 
//     */
//    public Field setMax(Integer max) {
//        if(max != null)
//            this.max = max;
//        return this;
//    }
//
//    /**
//     * @return the min
//     */
//    public int getMin() {
//        return min;
//    }
//
//    /**
//     * @param min the min to set
//     * @return 
//     */
//    public Field setMin(Integer min) {
//        if(min != null)
//            this.min = min;
//        return this;
//    }
//
//    /**
//     * @return the mask
//     */
//    public String getMask() {
//        return mask;
//    }

//    /**
//     * @param mask the mask to set
//     * @return 
//     */
//    public Field setMask(String mask) {
//        if(mask != null)
//            this.mask = mask;
//        return this;
//    }


    /**
     * @return the to_send
     */
    public String getTo_send() {
        return to_send;
    }

    /**
     * @param to_send the to_send to set
     * @return 
     */
    public Field setTo_send(String to_send) {
        this.to_send = to_send;
        return this;
    }

    /**
     * @return the regular
     */
    public String getRegular() {
        return regular;
    }

    /**
     * @param regular the regular to set
     */
    public Field setRegular(String regular) {
        this.regular = regular;
        return this;
    }

    /**
     * @return the parent
     */
    public String getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public Field setParent(String parent) {
        this.parent = parent;
        return this;
    }

    /**
     * @return the data_source
     */
    public String getData_source() {
        return data_source;
    }

    /**
     * @param data_source the data_source to set
     */
    public Field setData_source(String data_source) {
        this.data_source = data_source;
        return this;
    }

    /**
     * @return the input_type
     */
    public String getInput_type() {
        return input_type;
    }

    /**
     * @param input_type the input_type to set
     */
    public Field setInput_type(String input_type) {
        this.input_type = input_type;
        return this;
    }

    /**
     * @return the values
     */
    public List<String> getValues() {
        return values;
    }

    /**
     * @param values the values to set
     */
    public Field setValues(List<String> values) {
        this.values = values;
        return this;
    }
}
