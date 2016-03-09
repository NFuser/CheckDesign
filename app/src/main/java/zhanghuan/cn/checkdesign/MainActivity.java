package zhanghuan.cn.checkdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private List<CheckBean> checkBeanList;
    private MyAdapter mAdapter;
    private GridView mGridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDate();
    }

    private void initDate() {

        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        int day = calendar.getActualMaximum(Calendar.DATE); // 获取当前月的天数

        checkBeanList = new ArrayList<CheckBean>();
        for (int i = 0; i < day + 1; i++) {
            CheckBean checkBean = new CheckBean();
            if ((int) (Math.random() * 20 % 4) == 3) {
                checkBean.day = i;
                checkBean.check_status = CheckBean.CHECKED;
            } else if ((int) (Math.random() * 20 % 4) == 2) {
                checkBean.day = i;
                checkBean.check_status = CheckBean.CHECK_NO;
            } else {
                checkBean.day = i;
                checkBean.check_status = CheckBean.CHECK_WAIT;
            }

            checkBeanList.add(checkBean);
        }

        mAdapter = new MyAdapter(MainActivity.this);
        mAdapter.setListDate(checkBeanList);

        mGridview = (GridView) findViewById(R.id.main_gridview);
        mGridview.setAdapter(mAdapter);
    }
}
