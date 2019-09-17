package ryey.easer.databinding;
import ryey.easer.R;
import ryey.easer.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemActivityLogBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.c_script, 1);
        sViewsWithIds.put(R.id.tv_script, 2);
        sViewsWithIds.put(R.id.c_service, 3);
        sViewsWithIds.put(R.id.tv_service, 4);
        sViewsWithIds.put(R.id.c_status, 5);
        sViewsWithIds.put(R.id.tv_status, 6);
        sViewsWithIds.put(R.id.c_profile, 7);
        sViewsWithIds.put(R.id.tv_profile, 8);
        sViewsWithIds.put(R.id.c_extra, 9);
        sViewsWithIds.put(R.id.tv_extra, 10);
        sViewsWithIds.put(R.id.c_time, 11);
        sViewsWithIds.put(R.id.tv_time, 12);
    }
    // views
    @NonNull
    public final android.widget.TableRow cExtra;
    @NonNull
    public final android.widget.TableRow cProfile;
    @NonNull
    public final android.widget.TableRow cScript;
    @NonNull
    public final android.widget.TableRow cService;
    @NonNull
    public final android.widget.TableRow cStatus;
    @NonNull
    public final android.widget.TableRow cTime;
    @NonNull
    private final android.widget.FrameLayout mboundView0;
    @NonNull
    public final android.widget.TextView tvExtra;
    @NonNull
    public final android.widget.TextView tvProfile;
    @NonNull
    public final android.widget.TextView tvScript;
    @NonNull
    public final android.widget.TextView tvService;
    @NonNull
    public final android.widget.TextView tvStatus;
    @NonNull
    public final android.widget.TextView tvTime;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemActivityLogBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds);
        this.cExtra = (android.widget.TableRow) bindings[9];
        this.cProfile = (android.widget.TableRow) bindings[7];
        this.cScript = (android.widget.TableRow) bindings[1];
        this.cService = (android.widget.TableRow) bindings[3];
        this.cStatus = (android.widget.TableRow) bindings[5];
        this.cTime = (android.widget.TableRow) bindings[11];
        this.mboundView0 = (android.widget.FrameLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvExtra = (android.widget.TextView) bindings[10];
        this.tvProfile = (android.widget.TextView) bindings[8];
        this.tvScript = (android.widget.TextView) bindings[2];
        this.tvService = (android.widget.TextView) bindings[4];
        this.tvStatus = (android.widget.TextView) bindings[6];
        this.tvTime = (android.widget.TextView) bindings[12];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ItemActivityLogBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemActivityLogBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ItemActivityLogBinding>inflate(inflater, ryey.easer.R.layout.item_activity_log, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ItemActivityLogBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemActivityLogBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(ryey.easer.R.layout.item_activity_log, null, false), bindingComponent);
    }
    @NonNull
    public static ItemActivityLogBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemActivityLogBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/item_activity_log_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ItemActivityLogBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}