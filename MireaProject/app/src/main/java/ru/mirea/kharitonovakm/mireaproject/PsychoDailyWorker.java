package ru.mirea.kharitonovakm.mireaproject;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.util.Random;


public class PsychoDailyWorker extends Worker {

    private static final String[] TIPS = {
                    "· Первое. Старайся во всех удачах благодарить обстоятельства, а во всех неудачах винить только себя.\n",
                    "· Второе. Помни: нет безвыходных положений, кроме смерти. Никогда не опускайте руки. Пока мы живем, мы способны улучшить свою жизнь.\n",
                    "· Третье. Когда тебе плохо, найди того, кому ещё хуже, и помоги ему — тебе станет значительно лучше.\n",
                    "· Четвертое. Относись к другим людям так, как хотелось бы чтобы другие люди относились к тебе.\n",
                    "· Пятое. Не обстоятельства должны управлять человеком, а человек обстоятельствами.\n",
                    "· Шестое. Верь в Его Величество Случай и знай: случай приходит только к тем, кто всё делает для того, чтобы этот случай пришел. Знай: если, прожив день, ты не сделал ни одного доброго дела или за день не узнал ничего нового — день прожит напрасно.\n",
                    "· Седьмое. Самое ценное в нашей жизни — здоровье. О нем нужно заботиться. Спать столько, сколько требует организм. Больше двигаться, рационально питаться, объявить войну курению.\n",
                    "· Восьмое. Помните: жизнь любит удачливых. О прошедшем жалеть бесполезно.\n",
                    "· Девятое. Анализируйте каждый прожитый день — учиться лучше всего на собственных ошибках.\n",
                    "· Десятое. Лучшее лекарство от грусти, от стресса, от неудач — оптимизм."
    };

    public PsychoDailyWorker(
            @NonNull Context context,
            @NonNull WorkerParameters params) {
        super(context, params);
    }


    @NonNull
    @Override
    public Result doWork() {
        int tipIndex = new Random().nextInt(TIPS.length);
        String dailyTip = "Совет дня: " + TIPS[tipIndex];

        getApplicationContext().getSharedPreferences("PsychoTips", Context.MODE_PRIVATE)
                .edit()
                .putString("DailyTip", dailyTip)
                .apply();

        return Result.success();
    }
}