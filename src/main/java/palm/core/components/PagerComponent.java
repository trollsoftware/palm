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

import jcomposition.api.annotations.ShareProtected;
import palm.core.Optional;
import palm.core.components.interfaces.IItemComponent;
import palm.core.components.interfaces.IPresenterComponent;
import palm.core.components.interfaces.PagerComponentGenerated;
import palm.core.interfaces.viewcallbacks.IPagerViewCallbacks;

public abstract class PagerComponent<V extends IPagerViewCallbacks, I extends IItemComponent & IPresenterComponent>
        extends PagerComponentGenerated<V, I> {
    @Override
    public void loadNextPage() {
        setLoading(true);

        if (getItems().size() % getPageSize() != 0) {
            setLoading(false);
            getView().doNonNull(new Optional.NonNullAction<V>() {
                @Override
                public void action(V object) {
                    object.onPageLoaded();
                }
            });
            return;
        }
        onLoadPage(getItems().size() / getPageSize() + 1);
    }

    @ShareProtected
    protected abstract void onLoadPage(int page);
}
