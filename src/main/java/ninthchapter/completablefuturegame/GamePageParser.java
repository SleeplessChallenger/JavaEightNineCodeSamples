package ninthchapter.completablefuturegame;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ninthchapter.completablefuturegame.dataobjects.Boxscore;
import ninthchapter.completablefuturegame.dataobjects.Result;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.concurrent.CompletableFuture;

public class GamePageParser {

    public void saveResultList(List<Result> results) {
        results.parallelStream().forEach(this::saveResultToFile);
    }

    public void saveResultToFile(Result result) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Boxscore boxscore = result.getData().getBoxscore();

        String awayFname = boxscore.getAwayFname();
        String homeFname = boxscore.getHomeFname();
        String date = boxscore.getDate();

        String fileName = String.format("%s_%s_at_%s.txt", date, awayFname, homeFname);
        fileName = fileName.replaceAll("\\s+", "_").replaceAll(",", "");
        File dir = new File("build/data");
        dir.mkdir();

        try {
            File file = new File(dir + "/" + fileName);
            Files.write(file.toPath().toAbsolutePath(), gson.toJson(result).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getTotalScore(Result result) {
        Boxscore boxscore = result.getData().getBoxscore();

        String awayRuns = boxscore.getLinescore().getAwayTeamRuns();
        String homeRuns = boxscore.getLinescore().getHomeTeamRuns();

        return Integer.parseInt(awayRuns) + Integer.parseInt(homeRuns);
    }

    public OptionalInt getMaxScore(List<Result> results) {
        return results.stream()
                .mapToInt(this::getTotalScore)
                .max();
    }

    public Optional<Result> getMaxGame(List<Result> results) {
        return results.stream()
                .max(Comparator.comparingInt(this::getTotalScore));
    }

//    public void printGames(LocalDate startDate, int days) {
////        CompletableFuture<List<Result>> future =
//                CompletableFuture.supplyAsync(
////                        new GamePageLinksSupplier(startDate, days)) // get will be called
////                            .thenApply(new BoxScoreRetriever());
//
//        CompletableFuture<List<Result>> future =
//                CompletableFuture.supplyAsync(
//                                new GamePageLinksSupplier(startDate, days))
//                        .thenApply(new BoxScoreRetriever());
//
//        CompletableFuture<Void> futureWrite = future.thenAcceptAsync(this::saveResultToFile)
//    }
}
