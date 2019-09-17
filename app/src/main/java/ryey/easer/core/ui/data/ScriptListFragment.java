/*
 * Copyright (c) 2016 - 2018 Rui Zhao <renyuneyun@gmail.com>
 *
 * This file is part of Easer.
 *
 * Easer is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Easer is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Easer.  If not, see <http://www.gnu.org/licenses/>.
 */

package ryey.easer.core.ui.data;

import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

import ryey.easer.R;
import ryey.easer.core.EHService;
import ryey.easer.core.data.ScriptStructure;
import ryey.easer.core.data.storage.ScriptDataStorage;

public class ScriptListFragment extends AbstractDataListFragment<ScriptDataStorage> {

    static {
        TAG = "[ScriptListFragment] ";
    }

    @Override
    protected String title() {
        return getString(R.string.title_script);
    }

    @Override
    protected int helpTextRes() {
        return R.string.help_script;
    }

    @Override
    protected List<ListDataWrapper> queryDataList() {
        ScriptDataStorage dataStorage = ScriptDataStorage.getInstance(getContext());
        List<ListDataWrapper> dataWrapperList = new ArrayList<>();
        for (String name : dataStorage.list()) {
            ScriptStructure script = dataStorage.get(name);
            if (script.isActive()) {
                if (script.isValid()) {
                    dataWrapperList.add(new ListDataWrapper(name));
                } else {
                    dataWrapperList.add(new ListDataWrapper(name, R.color.colorText_invalid));
                }
            } else {
                dataWrapperList.add(new ListDataWrapper(name, R.color.colorText_scriptInactive));
            }
        }
        return dataWrapperList;
    }

    @Override
    protected void onDataChangedFromEditDataActivity() {
        super.onDataChangedFromEditDataActivity();
        EHService.reload(getContext());
    }

    @Override
    protected Intent intentForEditDataActivity() {
        return new Intent(getActivity(), EditScriptActivity.class);
    }
}
