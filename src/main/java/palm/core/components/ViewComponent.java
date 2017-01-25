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
import palm.core.components.interfaces.IViewComponent;
import palm.core.interfaces.viewcallbacks.IViewCallbacks;

public class ViewComponent<TView extends IViewCallbacks> implements IViewComponent<TView> {
    private TView view;

    @Override
    public TView getView() {
        return this.view;
    }

    @Override
    public boolean hasView() {
        return this.view != null;
    }

    @Override
    public void takeView(TView view) {
        this.view = view;
        onTakeView(view);
    }

    @Override
    public void dropView(TView view) {

    }

    @ShareProtected
    protected void onTakeView(TView view) {
        System.out.println("ViewComponent - OnTakeView");
    }
}
