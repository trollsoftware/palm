package palm.core.items;


import jcomposition.api.annotations.Bind;
import jcomposition.api.annotations.Composition;
import palm.core.components.interfaces.IPresenterComponent;
import palm.core.interfaces.viewcallbacks.ITextImageViewCallbacks;
import palm.core.components.interfaces.IImageComponent;
import palm.core.components.interfaces.ITextComponent;

@Bind(TextImageItemPresenter.class)
@Composition(name = "TextImagePresenterGenerated")
public interface ITextImageItemPresenter extends IPresenterComponent<ITextImageViewCallbacks>,
        ITextComponent<ITextImageViewCallbacks>, IImageComponent<ITextImageViewCallbacks> {
}
