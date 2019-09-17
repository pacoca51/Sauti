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

package ryey.easer.plugins.event.sms;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import ryey.easer.R;
import ryey.easer.commons.plugindef.InvalidDataInputException;
import ryey.easer.commons.plugindef.PluginViewFragment;
import ryey.easer.commons.plugindef.ValidData;

public class SmsPluginViewFragment extends PluginViewFragment<SmsEventData> {
    private EditText editText_sender;
    private EditText editText_content;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.plugin_event__sms, container, false);
        editText_sender = view.findViewById(R.id.editText_sender);
        editText_content = view.findViewById(R.id.editText_content);

        return view;
    }

    @Override
    protected void _fill(@ValidData @NonNull SmsEventData data) {
        SmsInnerData intentData = data.innerData;
        editText_sender.setText(intentData.sender);
        editText_content.setText(intentData.content);
    }

    @ValidData
    @NonNull
    @Override
    public SmsEventData getData() throws InvalidDataInputException {
        SmsInnerData intentData = new SmsInnerData();
        intentData.sender = editText_sender.getText().toString();
        intentData.content = editText_content.getText().toString();
        return new SmsEventData(intentData);
    }
}
