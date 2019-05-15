/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

/**
 *
 * @author Mostafa
 */
public interface Requests {
    
        public void add(String id, int x1, String x2, String x3, boolean state);
        public void modify(String id, int x1, String x2, String x3, boolean state);
        public void delete();
        public void reserve();
    
}
