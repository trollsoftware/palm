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


import palm.core.interfaces.viewcallbacks.IPagerViewCallbacks;

public class ListPresenter extends ListPresenterGenerated {
    @Override
    public int getPageSize() {
        return 10;
    }

    @Override
    protected void onLoadPage(int page) {

    }

    @Override
    protected void onTakeView(IPagerViewCallbacks view) {
        super.onTakeView(view);
    }
}
