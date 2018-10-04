/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transpayv1.data.response;

/**
 *
 * @author Work
 */
public class Country {
    private String Name;
    private String IsoCode;

    /**
     * @return the name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the IsoCode
     */
    public String getIsoCode() {
        return IsoCode;
    }

    /**
     * @param IsoCode the IsoCode to set
     */
    public void setIsoCode(String IsoCode) {
        this.IsoCode = IsoCode;
    }
}
