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
import palm.core.Preconditions;
import palm.core.components.interfaces.IRouterComponent;
import palm.core.interfaces.IRouter;

public class RouterComponent<TRouter extends IRouter> implements IRouterComponent<TRouter> {
    private WeakReference<TRouter> mRouterRef;

    @Override
    public TRouter getRouter() {
        return mRouterRef == null ? null : mRouterRef.get();
    }

    @Override
    public boolean hasRouter() {
        return mRouterRef != null && mRouterRef.get() != null;
    }

    @Override
    public void takeRouter(TRouter router) {
        Preconditions.checkNotNull(router, "router");

        final TRouter currentRouter = getRouter();
        if (currentRouter != router) {
            if (currentRouter != null) {
                dropRouter(currentRouter);
            }
            assignRouter(router);
            onTakeRouter(router);
        }
    }

    @Override
    public void dropRouter(TRouter router) {
        Preconditions.checkNotNull(router, "router");

        if (getRouter() == router) {
            onDropRouter(router);
            releaseRouter();
        }
    }

    void assignRouter(TRouter router) {
        mRouterRef = new WeakReference<TRouter>(router);
    }

    void releaseRouter() {
        if (mRouterRef != null) {
            mRouterRef.clear();
            mRouterRef = null;
        }
    }

    /**
     * Called after router is taken.
     *
     * @param router
     *     router attached to this presenter
     *
     * @see #takeRouter(IRouter)
     */
    @ShareProtected
    protected void onTakeRouter(TRouter router) {
    }

    /**
     * Called before router is dropped.
     *
     * @param router
     *     router is going to be dropped
     *
     * @see #dropRouter(IRouter)
     */
    @ShareProtected
    protected void onDropRouter(TRouter router) {
    }
}
