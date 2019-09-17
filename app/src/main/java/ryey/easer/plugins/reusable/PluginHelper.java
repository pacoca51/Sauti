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

package ryey.easer.plugins.reusable;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.IOException;
import java.io.OutputStream;

import ryey.easer.R;

public class PluginHelper {

    public static boolean useRootFeature(@NonNull Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(
                context.getString(R.string.key_pref_use_root), false);
    }

    public static Process executeCommandAsRoot(Context context, String command) throws IOException {
        return Runtime.getRuntime().exec(new String[] { "su", "-c", command});
    }

    public static Process executeCommandsAsRoot(String... commands) throws IOException {
        String[] all_commands = new String[commands.length+1];
        all_commands[0] = "su";
        System.arraycopy(commands, 0, all_commands, 1, commands.length);
        return executeCommands(all_commands);
    }

    public static Process executeCommandsContinuously(String... commands) throws IOException {
        String[] all_commands = new String[commands.length+1];
        all_commands[0] = "sh";
        System.arraycopy(commands, 0, all_commands, 1, commands.length);
        return executeCommands(all_commands);
    }

    public static Process executeCommands(String... command) throws IOException {
        Process process = Runtime.getRuntime().exec(command[0]);
        OutputStream out = process.getOutputStream();
        for (int i = 1; i < command.length; i++) {
            String cmd = command[i];
            if (!cmd.endsWith("\n"))
                cmd += "\n";
            out.write(cmd.getBytes());
        }
        return process;
    }

    public static boolean checkPermission(Context context, String... permissions) {
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(context, permission)
                    != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    public static void requestPermission(Activity activity, int requestCode, String... permissions) {
        ActivityCompat.requestPermissions(activity, permissions, requestCode);
    }

    public static void reenableComponent(Context context, Class cls) {
        PackageManager pm = context.getPackageManager();
        ComponentName componentName = new ComponentName(context, cls);

        pm.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);

        pm.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
    }

}
