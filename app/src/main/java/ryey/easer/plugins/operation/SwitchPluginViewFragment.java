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

package ryey.easer.plugins.operation;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import ryey.easer.R;
import ryey.easer.commons.plugindef.PluginViewFragment;
import ryey.easer.commons.plugindef.ValidData;
import ryey.easer.commons.plugindef.operationplugin.OperationData;

public abstract class SwitchPluginViewFragment<T extends OperationData> extends PluginViewFragment<T> {
    private Switch aSwitch;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.plugin_reusable__switch, container, false);
        aSwitch = view.findViewById(R.id.plugin_reusable__switch);
        return view;
    }

    private static void setSwitch(@NonNull Switch sw, boolean state) {
        sw.setChecked(state);
    }

    private static boolean fromSwitch(@NonNull Switch sw) {
        return sw.isChecked();
    }

    @Override
    protected void _fill(@ValidData @NonNull T data) {
        if (data instanceof BooleanOperationData) {
            Boolean state = ((BooleanOperationData) data).get();
            setSwitch(aSwitch, state);
        }
    }

    @NonNull
    protected Boolean state() {
        return fromSwitch(aSwitch);
    }
}
