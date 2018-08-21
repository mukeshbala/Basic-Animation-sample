package orgware.com.olaanimationsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edt_home_pickup)
    TextView edtHomePickup;
    @BindView(R.id.card_home_pickup)
    CardView cardHomePickup;
    @BindView(R.id.edt_home_drop)
    TextView edtHomeDrop;
    @BindView(R.id.card_home_drop)
    CardView cardHomeDrop;
    @BindView(R.id.edt_home_pickup_trans)
    TextView edtHomePickupTrans;
    @BindView(R.id.card_home_pickup_trans)
    CardView cardHomePickupTrans;
    @BindView(R.id.edt_home_trans)
    TextView edtHomeTrans;
    @BindView(R.id.card_home_trans)
    CardView cardHomeTrans;
    @BindView(R.id.card_home_enter)
    CardView cardHomeEnter;
    @BindView(R.id.card_home_drop_enter)
    CardView cardHomeDropEnter;
    @BindView(R.id.card_home_enter_up)
    CardView cardHomeEnterUp;
    @BindView(R.id.card_home_drop_enter_down)
    CardView cardHomeDropEnterDown;
    private Animation zoomIn, zoomOut, enter, leave, down, up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        zoomIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
        zoomOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);
        enter = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_enter);
        leave = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_leave);
        down = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
        up = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.sliide_up);

        cardHomePickup.startAnimation(zoomIn);
        cardHomeDrop.startAnimation(zoomOut);

    }

    @OnClick({R.id.card_home_pickup, R.id.card_home_drop, R.id.card_home_pickup_trans, R.id.card_home_trans
            , R.id.card_home_enter, R.id.card_home_drop_enter, R.id.card_home_enter_up, R.id.card_home_drop_enter_down})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.card_home_pickup:
                cardHomePickup.startAnimation(zoomIn);
                cardHomeDrop.startAnimation(zoomOut);
                break;
            case R.id.card_home_drop:
                cardHomePickup.startAnimation(zoomOut);
                cardHomeDrop.startAnimation(zoomIn);
                break;
            case R.id.card_home_pickup_trans:
                cardHomePickupTrans.setCardElevation(10f);
                cardHomeTrans.setCardElevation(3f);
                break;
            case R.id.card_home_trans:
                cardHomePickupTrans.setCardElevation(3f);
                cardHomeTrans.setCardElevation(10f);
                break;
            case R.id.card_home_enter:
                cardHomeEnter.startAnimation(enter);
                cardHomeDropEnter.startAnimation(leave);
                break;
            case R.id.card_home_drop_enter:
                cardHomeEnter.startAnimation(leave);
                cardHomeDropEnter.startAnimation(enter);
                break;
            case R.id.card_home_enter_up:
                cardHomeDropEnterDown.setCardElevation(3f);
                cardHomeEnterUp.setCardElevation(5f);
                cardHomeEnterUp.startAnimation(down);
                cardHomeDropEnterDown.startAnimation(up);
                break;
            case R.id.card_home_drop_enter_down:
                cardHomeDropEnterDown.setCardElevation(5f);
                cardHomeEnterUp.setCardElevation(3f);
                cardHomeDropEnterDown.startAnimation(up);
                cardHomeEnterUp.startAnimation(down);
                break;
        }
    }
}
