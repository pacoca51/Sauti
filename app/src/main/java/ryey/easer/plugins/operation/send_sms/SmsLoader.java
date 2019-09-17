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

package ryey.easer.plugins.operation.send_sms;

import android.content.Context;
import androidx.annotation.NonNull;
import android.telephony.SmsManager;

import ryey.easer.Utils;
import ryey.easer.commons.plugindef.ValidData;
import ryey.easer.commons.plugindef.operationplugin.OperationLoader;

public class SmsLoader extends OperationLoader<SmsOperationData> {
    public SmsLoader(Context context) {
        super(context);
    }

    @Override
    public boolean load(@ValidData @NonNull SmsOperationData data) {
        String destination = data.destination;
        String content = Utils.format(data.content);
        SmsManager smsManager = SmsManager.getDefault();
        if (smsManager == null)
            return false;
        smsManager.sendTextMessage(destination, null, content, null, null);
        return true;
    }
}
