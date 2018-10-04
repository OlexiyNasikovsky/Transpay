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
public class State {
    private String Id;
    private String Name;
    private String HasTown;

    /**
     * @return the Id
     */
    public String getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the HasTown
     */
    public String getHasTown() {
        return HasTown;
    }

    /**
     * @param HasTown the HasTown to set
     */
    public void setHasTown(String HasTown) {
        this.HasTown = HasTown;
    }
}
