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

package palm.core.logic;

import jcomposition.api.annotations.Bind;
import jcomposition.api.annotations.Composition;
import palm.core.components.interfaces.ICollectionComponent;
import palm.core.components.interfaces.IPresenterComponent;
import palm.core.components.interfaces.IRouterComponent;
import palm.core.interfaces.viewcallbacks.ICollectionViewCallbacks;
import palm.core.interfaces.IRouter;
import palm.core.items.ITextItemPresenter;

@Bind(MainPresenter.class)
@Composition(name = "MainPresenterGenerated")
public interface IMainPresenter extends
        IPresenterComponent<ICollectionViewCallbacks>,
        ICollectionComponent<ICollectionViewCallbacks, ITextItemPresenter>,
        IRouterComponent<IRouter> {
}
