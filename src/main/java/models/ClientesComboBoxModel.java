/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
*
* @author Alexandre Machado
* 
*/

public class ClientesComboBoxModel extends AbstractListModel implements ComboBoxModel{
    
List<Cliente> clientes;
    Cliente clienteSelecionado;

    public ClientesComboBoxModel() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return clientes.size();
    }

    @Override
    public Object getElementAt(int index) {
        return clientes.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if (anItem instanceof Cliente) {
            this.clienteSelecionado = (Cliente) anItem;
            fireContentsChanged(this.clienteSelecionado, 0, this.clientes.size());
        }
    }

    @Override
    public Object getSelectedItem() {
        return this.clienteSelecionado;
    }
    
    public void addProduto(Cliente p){
        this.clientes.add(p);
    }
    
    public void clear(){
        this.clientes.clear();
    }

}

