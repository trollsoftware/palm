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
import palm.core.interfaces.IPagerViewCallbacks;

public abstract class PagerComponent<V extends IPagerViewCallbacks, I extends IItemComponent>
        extends PagerComponentGenerated<V, I> {
    protected static final int DEFAULT_PAGE_SIZE = 10;

    @Override
    public int getPageSize() {
        return DEFAULT_PAGE_SIZE;
    }

    @Override
    public void loadNextPage() {
        setLoading(true);

        if (getItems().size() % getPageSize() != 0) {
            setLoading(false);
            if (hasView()) {
                getView().onPageLoaded();
            }
            return;
        }
        onLoadPage(getItems().size() / getPageSize() + 1);
    }

    @ShareProtected
    protected abstract void onLoadPage(int page);
}
