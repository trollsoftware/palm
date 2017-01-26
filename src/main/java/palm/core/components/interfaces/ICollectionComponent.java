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
import palm.core.components.CollectionComponent;
import palm.core.interfaces.viewcallbacks.ICollectionViewCallbacks;

import java.util.List;

/**
 * Contains logic for items collection
 */
@Bind(CollectionComponent.class)
public interface ICollectionComponent<TView extends ICollectionViewCallbacks, TItem extends IItemComponent> {
    TItem getItemAt(int index);

    List<TItem> getItems();

    void setItems(List<TItem> items);

    boolean isLoading();

    void setLoading(boolean isLoading);

    void onItemSelected(int index);

    void reloadData();
}
