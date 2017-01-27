package palm.core.items;


import jcomposition.api.annotations.Bind;
import jcomposition.api.annotations.Composition;
import palm.core.components.interfaces.IPresenterComponent;
import palm.core.interfaces.viewcallbacks.IImageItemViewCallbacks;
import palm.core.components.interfaces.IImageComponent;

@Bind(ImageItemPresenter.class)
@Composition(name = "ImagePresenterGenerated")
public interface IImageItemPresenter extends IPresenterComponent<IImageItemViewCallbacks>,
        IImageComponent<IImageItemViewCallbacks> {
}
