/*
 * Copyright 2017 TrollSoftware (a.shitikov73@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package palm.core.components;

import java.lang.ref.WeakReference;

import jcomposition.api.annotations.ShareProtected;
import palm.core.Optional;
import palm.core.Preconditions;
import palm.core.components.interfaces.IViewComponent;
import palm.core.interfaces.viewcallbacks.IViewCallbacks;

public class ViewComponent<TView extends IViewCallbacks> implements IViewComponent<TView> {
    private WeakReference<TView> mViewRef;
    private boolean isFirstTake = true;
    private boolean isRestored = true;

    @Override
    public Optional<TView> getView() {
        return (mViewRef == null
                ? null
                : Optional.of(mViewRef.get()));
    }

    @Override
    public void takeView(TView view) {
        Preconditions.checkNotNull(view);

        final Optional<TView> optional = getView();
        if (optional.orNull() != view) {
            if (optional.isPresent()) {
                dropView(optional.get());
            }
            assignView(view);
            if (isRestored) {
                onRestore(view);
                isRestored = false;
            }
            if (isFirstTake) {
                onFirstTake(view);
                isFirstTake = false;
            }
            onTakeView(view);
        }
    }

    @Override
    public void dropView(TView view) {
        Preconditions.checkNotNull(view);

        if (getView().orNull() == view) {
            onDropView(view);
            releaseView();
        }
    }

    @Override
    public void restore() {
        this.isRestored = true;
    }

    void assignView(TView view) {
        mViewRef = new WeakReference<TView>(view);
    }

    void releaseView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    @ShareProtected
    protected void onFirstTake(TView view) {
    }

    /**
     * Called after view is taken.
     *
     * @param view
     *     attached to presenter
     *
     * @see #takeView(IViewCallbacks)
     */
    @ShareProtected
    protected void onTakeView(TView view) {
    }

    /**
     * Called after presenter is restored from backstack
     */
    @ShareProtected
    protected void onRestore(TView view) {
    }

    /**
     * Called before view is dropped.
     *
     * @param view
     *     view is going to be dropped
     *
     * @see #dropView(IViewCallbacks)
     */
    @ShareProtected
    protected void onDropView(TView view) {
    }
}
