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
import palm.core.Optional;
import palm.core.components.RouterComponent;
import palm.core.interfaces.IRouter;

/**
 * Contains routing logic for {@link palm.core.components.PresenterComponent}
 */
@Bind(RouterComponent.class)
public interface IRouterComponent<TRouter extends IRouter> {
    /**
     * Returns the router managed by this presenter, or {@code null} if {@link #takeRouter} has never been called, or
     * after {@link #dropRouter}.
     *
     * @return {@code null}, if router is not taken, otherwise the concrete router instance.
     */
    Optional<TRouter> getRouter();

    /**
     * Called to give this presenter control of a router.
     * <p>
     * As soon as the reference to the router is assigned, it calls onTakeRouter callback.
     *
     * @param router
     *     router that will be returned from {@link #getRouter()}.
     */
    void takeRouter(TRouter router);

    /**
     * Called to surrender control of taken router.
     * <p>
     * It is expected that this method will be called with the same argument as {@link #takeRouter}. Mismatched routers
     * are ignored. This is to provide protection in the not uncommon case that {@code dropRouter} and {@code takeRouter}
     * are called out of order.
     * <p>
     * Calls onDropRouter before the reference to the router is cleared.
     *
     * @param router
     *     router is going to be dropped
     */
    void dropRouter(TRouter router);
}
