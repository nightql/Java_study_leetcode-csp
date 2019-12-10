package 周赛166;

import java.util.Arrays;

public class Solution_1283 {
    /**
     *
     * @param nums
     * @param threshold
     * @return
     */
    public static int smallestDivisor(int[] nums, int threshold) {
        int lo = 1, hi = 100_0000;
        while (lo < hi) {
            int mid = (hi + lo) / 2;
            int res = cal(nums, mid);
            if (res > threshold) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static int cal(int[] nums, int div) {
        int sum = 0;
        for (int n : nums) {
            sum += n / div;
            if (n % div != 0) {
                sum++;
            }
        }
        return sum;
    }

    public static int smallestDivisor2(int[] nums, int threshold) {
        int num = 0;
        int sum_num = 0;
//        从小到大排序
        Arrays.sort(nums);
//        System.out.println(nums.length);  1000
//        System.out.println(nums[nums.length-1]);  999779
        for (int i = 1; i < nums[nums.length-1]; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += Math.floor(nums[j]/i);
                if (nums[j]%i > 0) {
                    sum++;
                }
            }
            if (sum <= threshold) {
                num = i;
                break;
            }
        }
        return num;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 3, 5, 7, 11};
//        int threshold = 3;
        int[] nums = {18607,661054,599919,436792,219456,994855,781647,139499,294811,943168,369056,837788,25946,615498,345479,921763,167979,461852,567900,940420,836054,496071,851495,268259,553644,40999,708857,552630,553456,444927,655817,93733,881939,206736,932155,734577,133584,679785,719096,805392,779265,201412,446214,187571,714154,768682,11777,249357,350918,133570,186740,88335,299888,861419,252627,142351,190234,97265,393794,414033,461348,547057,295514,870004,755088,613928,396043,140385,841266,954912,965107,870533,996362,378051,897528,923412,524015,230079,365959,964610,366189,21484,654459,991255,131522,432011,974342,636571,915017,246335,547817,802752,136165,498380,692399,219888,333507,686003,329935,370279,660020,155221,543984,82897,604572,847892,692870,671590,384542,494377,23116,410970,983215,588168,73358,830752,991038,166250,834167,938917,366174,429259,62217,43456,772544,751284,687270,218147,579648,728848,101141,735921,972772,371007,374469,755845,957008,102500,169075,715334,836798,573221,292179,606544,267290,307704,438953,175063,476755,707316,388442,374745,584485,36115,92979,382627,21877,407990,107992,768434,378955,516620,21620,905200,241941,929324,221524,639380,790739,163122,835132,270379,360168,846163,434248,444035,673876,488028,921588,172392,919680,38556,297156,575022,119253,441441,732973,451970,973994,266770,179988,97779,448361,758364,651953,852022,615198,79006,951605,400260,406404,753835,141171,123639,318434,986804,945592,962331,862192,516831,418643,192852,221263,611139,967860,224106,964543,390071,14546,117765,488689,836698,588062,548348,834219,61419,646475,220463,872011,150750,674761,296520,257834,527862,756343,31308,714276,837367,507946,471171,535805,867409,223353,810800,381007,317497,469553,771299,759678,280151,813489,575506,936119,858728,97540,545777,428093,664033,778049,483175,978741,988385,61249,302781,370958,688327,980995,599247,667870,181457,468842,138507,535604,313971,15131,113469,116530,870624,161253,321377,424749,741827,960017,675421,610441,45231,142286,664287,159200,763251,513028,145720,514455,901255,699213,409533,911866,167988,151090,91039,855703,9942,373989,427063,208788,716957,706809,628264,982807,954161,28182,609047,754092,669071,489194,706906,843616,566817,8265,610307,331416,643148,35115,717192,56132,10214,471463,966033,637569,265266,144054,40207,669011,794434,21944,365575,680493,432541,663544,285255,984233,257439,714532,90201,91269,949094,483377,393712,215079,134498,704464,940716,137860,851022,581,567301,999596,842703,540544,555868,854789,581664,579167,513619,773078,929599,71138,775595,754052,967804,34629,147566,106952,90798,507673,882395,137850,224076,495173,762960,475945,306893,305492,107908,464911,539472,911367,550378,930222,712399,64259,78634,15841,713406,673326,382612,704443,180694,968406,458360,576469,12073,440246,743337,882407,97375,639512,339038,430979,458149,549323,62777,298251,92676,98008,796090,502348,617767,558582,747713,500720,470699,670685,957836,81753,908260,705510,26833,356425,941151,447123,709498,132455,388091,33455,636678,898508,426083,378263,11831,645293,180979,362500,998544,631364,860885,627551,220930,513521,444784,323518,288228,387883,98747,727747,290154,377968,840557,314411,166915,100724,879878,795076,748431,331540,553271,887750,712789,669765,509465,340041,283040,413384,122809,622337,999779,656422,92085,61407,893854,560651,91692,537078,321799,772220,826593,206938,919224,222443,523259,121335,472663,658408,703643,403244,623876,105507,915359,66167,207274,778641,874002,798327,791591,838122,945991,85273,811366,490813,171602,376099,509467,404606,221521,768444,421093,223002,655390,174553,478528,171383,702814,145734,134150,939249,768251,272443,110762,373829,852848,841552,61280,568530,95789,41826,452949,103054,551464,988232,468438,52852,475858,874109,439689,4381,984172,891993,541509,674319,62038,883283,564015,223821,319057,315290,304918,975059,952387,269627,642286,652413,828398,593046,654928,788130,640077,298081,522548,21148,205682,641598,462249,595430,572772,180097,786689,621801,322768,699604,952488,633362,519704,175083,989810,478354,995107,420327,683916,726540,156734,360041,617206,838548,135797,465593,264830,917216,770128,856661,936476,946938,28496,279815,980865,117036,112221,218870,914894,804245,511594,227596,783229,277253,15278,182687,576194,512172,529420,653179,120690,599142,316840,757408,70066,504811,422729,906049,150625,203997,239407,672072,159117,425367,372106,808301,687327,71570,357781,300394,290681,951213,820785,918921,132538,869401,373804,1628,962516,229561,10694,297,78343,277573,92951,865086,116747,997095,759067,131884,44557,909092,809690,161878,63828,362685,427656,148715,748734,102057,178466,34815,138378,293063,459512,643107,96019,915430,148083,275515,670424,786283,387461,790312,217484,952741,13,317458,429833,312935,917773,125480,435301,163891,65662,698543,731297,139015,10510,805645,667394,133588,953545,247753,766013,90455,184605,53415,617041,90048,326388,101124,974400,253397,754504,250248,450253,857790,138143,866888,795867,671073,476296,273763,54146,787220,391026,683862,936858,415637,306103,797376,648811,550846,149572,198007,946296,467507,269324,745454,99128,17608,240242,212765,695550,549789,531445,180101,590534,688254,573211,2414,128739,693151,691100,191980,851850,979149,422807,445108,132880,451155,661107,960371,42998,470844,161083,432271,740873,993362,496509,889444,336700,852778,471601,193461,723719,816109,125423,779133,308316,983275,575449,272494,199318,256643,893920,725533,253822,404254,559859,489422,5363,11031,67572,862567,255321,669914,632143,377038,554744,485604,696270,100250,662153,137542,343310,496277,610894,839159,19073,409140,641388,45905,915894,239045,985276,972656,385998,142099,93076,756410,754790,585572,765454,7290,151323,79580,386390,398486,799364,796845,165444,184353,743760,104882,898024,686662,10423,289372,442257,872479,567805,698582,69140,721575,120641,699134,896170,415473,354069,803226,782008,546104,150845,473303,780502,71363,97711,874302,536984,577677,397651,474040,65580,603414,508767,569479,333089,755006,889758,348780,798676,952963,985064,226045,473875,837716,240801,925740,723996,8815,768860,125574,631988,736322,440117,446319,956107,77845,424856,7913,249594,110884,780944,781288,588799,194583,490172,674160,240926,875506,115077,846916,819064,141146,196873,837473,856420,887690,910918,264003,101138,143669,103533,261491,819237,62727,522438,824050,884366,481096,494294,277179,282425,914015,186941,700032,733865,971402,232350,887661,495860,637260,67893,325713,92020,429761,77685,779909,213726,351600,161725,396017,495455,425953,616180,177135,894294,167467,200258,204898,527306,11619,460195,613497,978613,73669,405709,697918,694843,945282,453480,341684,964068,74506,851485,472020,704098,217984,193220,161309,963157,454140,162559,89365,534910,646841,451192,735112,927211,787000,301881,559225,367400,525859,224834,437794,906299,119526,837518,794126,44306,222608,569819,642630,591670,448114,669572,190568,415079};
        int threshold = 2118;
//        System.out.println(smallestDivisor(nums, threshold));
        int a = 3/2;
        System.out.println(a);
    }
}
