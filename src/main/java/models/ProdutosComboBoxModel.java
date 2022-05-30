package models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author alexa
 */
public class ProdutosComboBoxModel extends AbstractListModel implements ComboBoxModel {

    List<Produto> produtos;
    Produto produtoSelecionado;

    public ProdutosComboBoxModel() {
        this.produtos = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return produtos.size();
    }

    @Override
    public Object getElementAt(int index) {
        return produtos.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if (anItem instanceof Produto) {
            this.produtoSelecionado = (Produto) anItem;
            fireContentsChanged(this.produtoSelecionado, 0, this.produtos.size());
        }
    }

    @Override
    public Object getSelectedItem() {
        return this.produtoSelecionado;
    }
    
    public void addProduto(Produto p){
        this.produtos.add(p);
    }
    
    public void clear(){
        this.produtos.clear();
    }

}
