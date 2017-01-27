package palm.core.components.interfaces;


import jcomposition.api.annotations.Bind;
import palm.core.interfaces.viewcallbacks.IImageItemViewCallbacks;
import palm.core.components.ImageComponent;

@Bind(ImageComponent.class)
public interface IImageComponent<TView extends IImageItemViewCallbacks> extends IItemComponent<TView> {
    void setImagePath(String path);
}

