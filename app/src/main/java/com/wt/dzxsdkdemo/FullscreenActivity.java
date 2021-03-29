package com.wt.dzxsdkdemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.wt.dzxsdk.DZXSDK;

//冲突库测试 Start
import com.github.mikephil.charting.data.PieEntry;
import com.google.gson.Gson;
//冲突库测试 End

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {
    private static final String TAG = "FullscreenActivity";

    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private boolean mVisible;
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };
    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
                delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);

        mVisible = true;
        mControlsView = findViewById(R.id.fullscreen_content_controls);
        mContentView = findViewById(R.id.fullscreen_content);


        // Set up the user interaction to manually show or hide the system UI.
        mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle();
            }
        });

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
        findViewById(R.id.dummy_button).setOnTouchListener(mDelayHideTouchListener);

        //冲突库测试 Start
        //MPAndroidChart
        PieEntry thePieEntry=null;
        Gson theGson = null;
        //冲突库测试 End
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }

    private void toggle() {
        if (mVisible) {
            hide();
        } else {
            show();
        }
    }

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mControlsView.setVisibility(View.GONE);
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    @SuppressLint("InlinedApi")
    private void show() {
//        // Show the system bar
//        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
//        mVisible = true;
//
//        // Schedule a runnable to display UI elements after a delay
//        mHideHandler.removeCallbacks(mHidePart2Runnable);
//        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }

    /**
     * Schedules a call to hide() in delay milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }

    public void onClickButton1(View v) {
        String strUserID="oJ0qB1utZD9wm8c4rxl7eoBgmUkc";
        DZXSDK.openUI_CameraList(this,strUserID);
    }

    public void onClickButton2(View v) {
//        String strDeviceSerial="C32940646";
//        String strDeviceSerial="D39981692";
//        String strDeviceSerial="D38253294";
//        int iCameraIndex=0;
//        int iCameraIndex=5;

//        String strDeviceSerial="D30410400";
//        int iCameraIndex=1;

//        String strDeviceSerial="D19841866";
//        int iCameraIndex=1;

//        String strDeviceSerial="D29540847";
//        int iCameraIndex=2;
//        String strDeviceSerial="D36456024";
//        int iCameraIndex=0;

//        String strDeviceSerial="D29540847";
//        int iCameraIndex=7;
//        String strDeviceSerial="D36456106";
//        int iCameraIndex=0;

//        String strDeviceSerial="D33502508";
//        int iCameraIndex=1;
//        String strDeviceSerial="D31094344";
//        int iCameraIndex=0;

//        String strDeviceSerial="D78236630";
//        int iCameraIndex=0;

//        String strDeviceSerial="D80914368";
//        int iCameraIndex=2;

        //String strDeviceSerial="D33502508";
        //String strDeviceSerial="D84617045";
        String strDeviceSerial="F47870009";
        String strCamera=getCamera();
        if ( strCamera.length()>6 )
        {
            strDeviceSerial=strCamera;
        }
        int iCameraIndex=3;
        int iChannel=getChannel();
        if ( iChannel>=0 )
        {
            iCameraIndex=iChannel;
        }

        DZXSDK.openUI_CameraRealPlay(this,strDeviceSerial,iCameraIndex);
    }

    public void onClickButton3(View v) {
//        String strDeviceSerial="C32940646";
//        int iCameraIndex=4;

//        String strDeviceSerial="D30410400";
//        int iCameraIndex=1;

//        String strDeviceSerial="D31094344";
//        int iCameraIndex=0;
        String strDeviceSerial="D84617045";
        String strCamera=getCamera();
        if ( strCamera.length()>6 )
        {
            strDeviceSerial=strCamera;
        }
        int iCameraIndex=3;
        int iChannel=getChannel();
        if ( iChannel>=0 )
        {
            iCameraIndex=iChannel;
        }


//        String strDeviceSerial="D29540847";
//        int iCameraIndex=2;

//        String strDeviceSerial="D29540847";
//        int iCameraIndex=7;

        DZXSDK.openUI_CameraPlayBack(this,strDeviceSerial,iCameraIndex);
    }

    public void onClickButton4(View v) {
        MyApplication theMyApplication=(MyApplication)getApplication();
        DZXSDK.openUI_CheckYSSDK(90010,this,theMyApplication);
    }

    public void onClickButton5(View v) {
        DZXSDK.openUI_setStrWaterMark(90010,"自定义水印");
    }

    private TextView textViewChannel = null;
    private EditText editTextCameraCode = null;
    public String getCamera(){
        if ( editTextCameraCode==null )
        {
            editTextCameraCode = findViewById(R.id.editTextCameraCode);
        }
        String strCamera=editTextCameraCode.getText().toString();
        if ( strCamera.length()<8 )
        {
            return "";
        }
        return strCamera;
    }
    public int getChannel() {
        if ( textViewChannel==null )
        {
            textViewChannel = findViewById(R.id.textViewChannel);
            //return -1;
        }
        String strChannel=textViewChannel.getText().toString();
        if ( strChannel.length()<1 )
        {
            return -2;
        }
        int iChannel=Integer.parseInt(strChannel);
        return iChannel;
    }
    public void setChannel(int iChannel) {
        if ( iChannel<0 )
        {
            return;
        }
        if ( textViewChannel==null )
        {
            textViewChannel = findViewById(R.id.textViewChannel);
        }
        textViewChannel.setText(""+iChannel);
    }
    public void onClickButtonJian(View v) {
        int iChannel=getChannel();
        iChannel=iChannel-1;
        if ( iChannel<0 )
        {
            iChannel=0;
        }
        setChannel(iChannel);
    }

    public void onClickButtonJia(View v) {
        int iChannel=getChannel();
        iChannel=iChannel+1;
        if ( iChannel<0 )
        {
            iChannel=0;
        }
        setChannel(iChannel);
    }

}
