package com.example.useco_ordinatorlayout.Utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

import com.example.useco_ordinatorlayout.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
/**
 * We need to add constructor here cause we have define our custom Behaviour for co-ordinator Layout
 * Our co-ordinator will use this {CustomScrollFabBehaviour()} to let the behaviour change for FAB.
 * NOTE: if we don't add default constructor we will get Error
 * */
public class CustomScrollFabBehaviour extends FloatingActionButton.Behavior {
    private boolean isDownImageShow = false;

    public CustomScrollFabBehaviour(Context context, AttributeSet attrs) {

    }

    public CustomScrollFabBehaviour(){
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

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull FloatingActionButton child, @NonNull View dependency) {
        return dependency instanceof Snackbar.SnackbarLayout; // when should we do certain behaviour
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, @NonNull FloatingActionButton child, View dependency) {
        // what should we do when certain dependency meets
        if (dependency instanceof Snackbar.SnackbarLayout && !isDownImageShow){
            child.setImageResource(R.drawable.arrow_upward);
            isDownImageShow = true;
        }
        return false;
    }

    @Override
    public void onDependentViewRemoved(@NonNull CoordinatorLayout parent, @NonNull FloatingActionButton child, @NonNull View dependency) {
        super.onDependentViewRemoved(parent, child, dependency);
        // what should we do when the certain dependency is removed
        if (dependency instanceof Snackbar.SnackbarLayout && isDownImageShow){
            child.setImageResource(R.drawable.arrow_downward);
            isDownImageShow = false;
        }
    }
}
