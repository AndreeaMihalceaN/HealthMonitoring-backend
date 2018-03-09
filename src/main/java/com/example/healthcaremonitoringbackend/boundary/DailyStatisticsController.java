package com.example.healthcaremonitoringbackend.boundary;

import com.example.healthcaremonitoringbackend.entity.DailyStatistics;
import com.example.healthcaremonitoringbackend.entity.Day;
import com.example.healthcaremonitoringbackend.entity.Food;
import com.example.healthcaremonitoringbackend.entity.UserDiary;
import com.example.healthcaremonitoringbackend.repository.DailyStatisticsRepository;
import com.example.healthcaremonitoringbackend.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping(path = "/dailyStatistics")
public class DailyStatisticsController {

    @Autowired
    private DailyStatisticsRepository dailyStatisticsRepository;

    @Autowired
    private DayRepository dayRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewDailyStatistics(@RequestBody DailyStatistics dailyStatistics) {

        dailyStatisticsRepository.save(dailyStatistics);
        return "DailyStatistics Saved";

    }

    @PostMapping(path = "/add2")
    public @ResponseBody
    String addNewFood(@RequestParam Long dayId, @RequestParam double totalCalories, @RequestParam Long userId, @RequestParam double steps) {

        DailyStatistics dailyStatistics = new DailyStatistics();
        dailyStatistics.setDayId(dayId);
        dailyStatistics.setTotalCalories(totalCalories);
        dailyStatistics.setUserId(userId);
        dailyStatistics.setSteps(steps);

        dailyStatisticsRepository.save(dailyStatistics);
        return "DailyStatistics object Saved";

    }


    @PostMapping(path = "/updateDailyStatistics")
    public @ResponseBody
    String updateUserDiaryQuantity(@RequestParam double quantity, @RequestParam Long userId, @RequestParam Long dayId) {

        DailyStatistics oldDailyStatistics = dailyStatisticsRepository.findDailyStatisticsByDayIdAndUserId(dayId, userId);
        oldDailyStatistics.setTotalCalories(quantity);

        dailyStatisticsRepository.save(oldDailyStatistics);
        return "Updated quantity for an existing DailyStatistics";

    }

    @PostMapping(path = "/searchDailyStatistics")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    DailyStatistics getDailyStatistics(@RequestParam Long userId, @RequestParam Long dayId) {
        return dailyStatisticsRepository.findDailyStatisticsByDayIdAndUserId(dayId, userId);
    }

    @PostMapping(path = "/searchDailyStatisticsByUserId")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    List<DailyStatistics> getDailyStatisticsByUserId(@RequestParam Long userId) {
        return dailyStatisticsRepository.findDailyStatisticsByUserId(userId);
    }

//    @PostMapping(path = "/fillDayAndDailyStatistics")
//    public @ResponseBody
//        //@RequestParam(name = "user_name") String username, @RequestParam String password
//    String fillDayAndDailyStatistics(@RequestParam Long userId, String calendarString) throws ParseException {
//
//        List<DailyStatistics> dailyStatisticsListForUser = dailyStatisticsRepository.findDailyStatisticsByUserId(userId);
//        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//        //Calendar cal = Calendar.getInstance();
////        cal.setTime(df.parse(calendarString));
//        //Day day = dayRepository.findDayByDate(cal);
//
//        Day day = dayRepository.findDayById(dailyStatisticsListForUser.get(dailyStatisticsListForUser.size() - 2).getDayId());
//        Date dayObject = day.getDate().getTime();
//        String lastDay = df.format(dayObject);
//
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(df.parse(calendarString));
//        Day today = dayRepository.findDayByDate(cal);
//
//        cal = today.getDate();
//
//        cal.setTime(new Date());
//        cal.add(Calendar.DAY_OF_YEAR, -1);
//        Date dayPrev = cal.getTime();
//        //String dateString = dayPrev.toString();
//        String dateForTask = df.format(dayPrev);
//
//        String result = "";
//        int i = 1;
//        result += lastDay + " " + dateForTask;
//        while (!lastDay.equals(dateForTask)) {
//
//            //add new day
//            if (dayRepository.findDayByDate(cal) == null) {
//                Day newDay = new Day();
//                Calendar newCal = Calendar.getInstance();
//                cal.setTime(df.parse(dateForTask));
//                newDay.setDate(newCal);
//                dayRepository.save(newDay);
//
//                //add new dailyStatistics
//                DailyStatistics dailyStatistics = new DailyStatistics();
//                Day searchDay = dayRepository.findDayByDate(newDay.getDate());
//                dailyStatistics.setDayId(searchDay.getId());
//                dailyStatistics.setTotalCalories(0);
//                dailyStatistics.setUserId(userId);
//                dailyStatistics.setSteps(0);
//                dailyStatisticsRepository.save(dailyStatistics);
//
//
//                result += "Succesful!" + dateForTask;
//            }
//            cal.setTime(new Date());
//            cal.add(Calendar.DAY_OF_YEAR, -i);
//            dayPrev = cal.getTime();
//            //String dateString = dayPrev.toString();
//            dateForTask = df.format(dayPrev);
//            i--;
//
//
//        }
//
//        //DailyStatistics dailyStatistics = dailyStatisticsRepository.findDailyStatisticsByDayIdAndUserId(day.getId(), userId);
//        return result;
//
//    }

    @PostMapping(path = "/searchDailyStatisticsByUserAndDate")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    DailyStatistics getDailyStatistics(@RequestParam Long userId, @RequestParam String dateString) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(df.parse(dateString));

        Day day = dayRepository.findDayByDate(cal);

        return dailyStatisticsRepository.findDailyStatisticsByDayIdAndUserId(day.getId(), userId);
    }

    @PostMapping(path = "/updateDailyStatisticsSteps")
    public @ResponseBody
    String updateUserDiarySteps(@RequestParam double steps, @RequestParam Long userId, @RequestParam Long dayId) {

        DailyStatistics oldDailyStatistics = dailyStatisticsRepository.findDailyStatisticsByDayIdAndUserId(dayId, userId);
        oldDailyStatistics.setSteps(steps);

        dailyStatisticsRepository.save(oldDailyStatistics);
        return "Updated steps for an existing DailyStatistics";

    }

}
