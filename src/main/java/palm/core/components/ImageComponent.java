package palm.core.components;


import jcomposition.api.annotations.ShareProtected;
import palm.core.components.interfaces.IImageComponent;
import palm.core.interfaces.viewcallbacks.IImageItemViewCallbacks;

public abstract class ImageComponent<TView extends IImageItemViewCallbacks> implements IImageComponent<TView> {
    private String path;

    @ShareProtected
    protected void onTakeView(TView view) {
        view.getImage(); // loadImage(path)
    }

    @Override
    public void setImagePath(String path) {
        this.path = path;
    }
}
