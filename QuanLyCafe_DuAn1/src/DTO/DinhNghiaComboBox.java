/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Ridotoji Pham
 */
public class DinhNghiaComboBox {
    public Object DisplayMmber;
    public  Object DisplayValue;
    
      public  DinhNghiaComboBox(Object Member, Object value){
        DisplayMmber = Member;
        DisplayValue = value;
    }
      
      public String toString(){
          return  DisplayMmber.toString();
      }
}
