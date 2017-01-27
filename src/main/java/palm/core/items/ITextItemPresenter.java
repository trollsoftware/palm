package palm.core.items;


import jcomposition.api.annotations.Bind;
import jcomposition.api.annotations.Composition;
import palm.core.components.interfaces.IPresenterComponent;
import palm.core.interfaces.viewcallbacks.ITextItemViewCallbacks;
import palm.core.components.interfaces.ITextComponent;

@Bind(TextItemPresenter.class)
@Composition(name = "TextPresenterGenerated")
public interface ITextItemPresenter extends IPresenterComponent<ITextItemViewCallbacks>,
        ITextComponent<ITextItemViewCallbacks> {
}
