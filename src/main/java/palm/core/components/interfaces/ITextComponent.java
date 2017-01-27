package palm.core.components.interfaces;


import jcomposition.api.annotations.Bind;
import palm.core.interfaces.viewcallbacks.ITextItemViewCallbacks;
import palm.core.components.TextComponent;

@Bind(TextComponent.class)
public interface ITextComponent<TView extends ITextItemViewCallbacks> extends IItemComponent<TView> {
    void setText(String text);
}
