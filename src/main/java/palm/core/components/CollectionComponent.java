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

import palm.core.Optional;
import palm.core.components.interfaces.ICollectionComponent;
import palm.core.components.interfaces.IItemComponent;
import palm.core.components.interfaces.IPresenterComponent;
import palm.core.components.interfaces.IViewComponent;
import palm.core.interfaces.viewcallbacks.ICollectionViewCallbacks;

import java.util.ArrayList;
import java.util.List;

public abstract class CollectionComponent<TView extends ICollectionViewCallbacks, TItem extends IItemComponent & IPresenterComponent>
        implements ICollectionComponent<TView, TItem>, IViewComponent<TView> {

    private boolean loading;
    private List<TItem> items = new ArrayList<TItem>();

    @Override
    public TItem getItemAt(int index) {
        return items.get(index);
    }

    @Override
    public List<TItem> getItems() {
        return this.items;
    }

    @Override
    public void setItems(List<TItem> items) {
        this.items = items;
    }

    @Override
    public boolean isLoading() {
        return this.loading;
    }

    @Override
    public void setLoading(boolean isLoading) {
        this.loading = isLoading;
    }

    @Override
    public void onItemSelected(int index) {
        getItemAt(index).onSelect(index);
    }

    @Override
    public void reloadData() {
        getView().doNonNull(new Optional.NonNullAction<TView>() {
            @Override
            public void action(TView object) {
                object.reloadData();
            }
        });
    }
}
