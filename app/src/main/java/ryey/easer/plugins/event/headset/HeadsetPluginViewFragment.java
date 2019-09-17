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

package ryey.easer.plugins.event.headset;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import ryey.easer.R;
import ryey.easer.Utils;
import ryey.easer.commons.plugindef.InvalidDataInputException;
import ryey.easer.commons.plugindef.PluginViewFragment;
import ryey.easer.commons.plugindef.ValidData;

public class HeadsetPluginViewFragment extends PluginViewFragment<HeadsetEventData> {
    private static final int[] ids_hs_action = {
            R.id.radioButton_plug_in,
            R.id.radioButton_plug_out,
            R.id.radioButton_plug_any,
    };
    private static final int[] ids_hs_type = {
            R.id.radioButton_micro_true,
            R.id.radioButton_micro_false,
            R.id.radioButton_micro_any,
    };

    private RadioButton[] radioButtons_hs_action = new RadioButton[ids_hs_action.length];
    private RadioButton[] radioButtons_hs_type = new RadioButton[ids_hs_type.length];

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.plugin_event__headset, container, false);
        for (int i = 0; i < ids_hs_action.length; i++) {
            radioButtons_hs_action[i] = v.findViewById(ids_hs_action[i]);
        }
        for (int i = 0; i < ids_hs_type.length; i++) {
            radioButtons_hs_type[i] = v.findViewById(ids_hs_type[i]);
        }
        return v;
    }

    @Override
    protected void _fill(@ValidData @NonNull HeadsetEventData data) {
        radioButtons_hs_action[data.hs_action.ordinal()].setChecked(true);
        radioButtons_hs_type[data.hs_type.ordinal()].setChecked(true);
    }

    @ValidData
    @NonNull
    @Override
    public HeadsetEventData getData() throws InvalidDataInputException {
        return new HeadsetEventData(
                HeadsetEventData.HeadsetAction.values()[Utils.checkedIndexFirst(radioButtons_hs_action)],
                HeadsetEventData.HeadsetType.values()[Utils.checkedIndexFirst(radioButtons_hs_type)]
        );
    }
}
