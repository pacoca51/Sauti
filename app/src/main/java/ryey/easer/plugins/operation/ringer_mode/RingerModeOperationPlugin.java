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

package ryey.easer.plugins.operation.ringer_mode;

import android.Manifest;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import ryey.easer.R;
import ryey.easer.commons.plugindef.PluginViewFragment;
import ryey.easer.commons.plugindef.operationplugin.Category;
import ryey.easer.commons.plugindef.operationplugin.OperationDataFactory;
import ryey.easer.commons.plugindef.operationplugin.OperationLoader;
import ryey.easer.commons.plugindef.operationplugin.OperationPlugin;
import ryey.easer.commons.plugindef.operationplugin.PrivilegeUsage;
import ryey.easer.plugins.reusable.PluginHelper;

public class RingerModeOperationPlugin implements OperationPlugin<RingerModeOperationData> {

    @NonNull
    @Override
    public String id() {
        return "ringer_mode";
    }

    @Override
    public int name() {
        return R.string.operation_ringer_mode;
    }

    @Override
    public boolean isCompatible(@NonNull final Context context) {
        return true;
    }

    @NonNull
    @Override
    public PrivilegeUsage privilege() {
        return PrivilegeUsage.no_root;
    }

    @Override
    public int maxExistence() {
        return 1;
    }

    @NonNull
    @Override
    public Category category() {
        return Category.system_config;
    }

    @Override
    public boolean checkPermissions(@NonNull Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return PluginHelper.checkPermission(context, Manifest.permission.MODIFY_AUDIO_SETTINGS);
        } else {
            return PluginHelper.checkPermission(context, Manifest.permission.MODIFY_AUDIO_SETTINGS)
                    && isServiceEnabled(context);
        }
    }

    @Override
    public void requestPermissions(@NonNull Activity activity, int requestCode) {
        if (!PluginHelper.checkPermission(activity, Manifest.permission.MODIFY_AUDIO_SETTINGS))
            PluginHelper.requestPermission(activity, requestCode, Manifest.permission.MODIFY_AUDIO_SETTINGS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (!isServiceEnabled(activity)) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
                    activity.startActivity(new Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS));
                } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    PluginHelper.requestPermission(activity, requestCode,
                            Manifest.permission.BIND_NOTIFICATION_LISTENER_SERVICE);
                }
                PluginHelper.reenableComponent(activity, InterruptionFilterSwitcherService.class);
            }
        }
    }

    private static boolean isServiceEnabled(Context context) {
        PackageManager pm = context.getPackageManager();
        ComponentName componentName = new ComponentName(context, InterruptionFilterSwitcherService.class);
        return pm.getComponentEnabledSetting(componentName) == PackageManager.COMPONENT_ENABLED_STATE_ENABLED;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private static void toggleNotificationListenerService(Context context) {
        PackageManager pm = context.getPackageManager();
        ComponentName componentName = new ComponentName(context, InterruptionFilterSwitcherService.class);

        pm.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);

        pm.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);

    }

    @NonNull
    @Override
    public OperationDataFactory<RingerModeOperationData> dataFactory() {
        return new RingerModeOperationDataFactory();

    }

    @NonNull
    @Override
    public PluginViewFragment<RingerModeOperationData> view() {
        return new RingerModePluginViewFragment();
    }

    @NonNull
    @Override
    public OperationLoader<RingerModeOperationData> loader(@NonNull Context context) {
        return new RingerModeLoader(context);
    }

}
