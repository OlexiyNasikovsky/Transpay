/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transpayv1.util;

import java.io.IOException;

/**
 *
 * @author Work
 */
public class MissOfArgumentException extends IOException{
    public MissOfArgumentException(String message) {
        super(message);
    }
}
