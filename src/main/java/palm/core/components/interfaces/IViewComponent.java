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

package palm.core.components.interfaces;

import jcomposition.api.annotations.Bind;
import palm.core.components.ViewComponent;
import palm.core.interfaces.viewcallbacks.IViewCallbacks;

/**
 * Contains view logic for {@link palm.core.components.PresenterComponent}
 */
@Bind(ViewComponent.class)
public interface IViewComponent<TView extends IViewCallbacks> {
    /**
     * Returns the view managed by presenter, or {@code null} if {@link #takeView} has never been called, or after
     * {@link #dropView}.
     * <p>
     * You should always call {@link #hasView} to check if the view is taken to avoid NullPointerExceptions.
     *
     * @return {@code null}, if view is not taken, otherwise the concrete view instance.
     */
    TView getView();

    /**
     * Checks if a view is attached to presenter. You should always call this method before calling {@link #getView}
     * to get the view instance.
     *
     * @return {@code true} if presenter has attached view
     */
    boolean hasView();

    /**
     * Called to give presenter control of a view.
     * <p>
     * As soon as the reference to the view is assigned, it calls onTakeView callback.
     *
     * @param view
     *     view that will be returned from {@link #getView()}.
     */
    void takeView(TView view);

    /**
     * Called to surrender control of taken view.
     * <p>
     * It is expected that this method will be called with the same argument as {@link #takeView}. Mismatched views are
     * ignored. This is to provide protection in the not uncommon case that {@code dropView} and {@code takeView} are
     * called out of order.
     * <p>
     * Calls onDropView before the reference to the view is cleared.
     *
     * @param view
     *     view is going to be dropped.
     */
    void dropView(TView view);

    /**
     * Called when presenter is restored from backstack
     * Sets flag isRestored to true
     */
    void restore();
}
