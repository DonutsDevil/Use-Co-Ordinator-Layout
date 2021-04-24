package com.example.useco_ordinatorlayout.Utils;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

import com.example.useco_ordinatorlayout.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;
/**
 * This will give are FAB behaviour change i.e when we scroll vertically down FAB will not be visible
 * but if we scroll up FAB will be visible
 * We use Default Constructor so that our coordinator layout can use our behaviour
 * NOTE: If we don't add {ScrollAwareFABBehaviour()} we will get error.
 * */
public class ScrollAwareFABBehaviour extends FloatingActionButton.Behavior  {

    public ScrollAwareFABBehaviour(Context context, AttributeSet attrs) {

    }

    public ScrollAwareFABBehaviour(){
        super();
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout,
                                       @NonNull FloatingActionButton child,
                                       @NonNull View directTargetChild,
                                       @NonNull View target, int axes, int type) {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL ||
                super.onStartNestedScroll(coordinatorLayout, child, directTargetChild,
                        target, axes, type);
    }

    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout,
                               @NonNull FloatingActionButton child, @NonNull View target,
                               int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed,
                               int type, @NonNull int[] consumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed,
                dxUnconsumed, dyUnconsumed, type, consumed);

        if (dyConsumed > 0 && child.getVisibility() == View.VISIBLE){
            child.hide(new FloatingActionButton.OnVisibilityChangedListener() {
                @Override
                public void onHidden(FloatingActionButton fab) {
                    super.onHidden(fab);
                    fab.setVisibility(View.INVISIBLE);
                }
            });
        }else if( dyConsumed < 0 && child.getVisibility() != View.VISIBLE){
            child.show();
        }
    }
}
