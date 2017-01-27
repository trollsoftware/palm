package palm.core.components;

import jcomposition.api.annotations.ShareProtected;
import palm.core.components.interfaces.ITextComponent;
import palm.core.interfaces.viewcallbacks.ITextItemViewCallbacks;

public abstract class TextComponent<TView extends ITextItemViewCallbacks> implements ITextComponent<TView> {
    private String text;

    @ShareProtected
    protected void onTakeView(TView view) {
        view.getText(); // setText(text)
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }
}
