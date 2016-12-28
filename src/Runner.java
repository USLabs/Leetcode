import java.lang.reflect.Array;
import java.util.*;

public class Runner {
    public static void main(String[] args) {

        String[] argg = {
                "10",
                "-75",
                "346 341",
                "347",
                "-200 -54 -1",
                "464 94",
                "175",
                "45 -81 -286 -219",
                "-98 -61 500",
                "39 -44",
                "-39",
                "21 86 226 -218 20",
                "-122 211 47 413",
                "-245 12 -290",
                "474 417",
                "121",
                "337 426 493 173 -108 -270",
                "281 184 -183 126 149",
                "-181 103 251 -161",
                "127 -356 -12",
                "416 -201",
                "72",
                "-334 74 492 452 202 500 226",
                "-262 46 -281 448 -156 275",
                "-316 109 68 28 -335",
                "-51 500 187 141",
                "-308 500 43",
                "-118 500",
                "95",
                "-330 381 500 401 -173 404 -85 92",
                "33 500 -107 453 296 -287 -331",
                "-57 461 152 385 -138 -120",
                "-294 452 131 -90 208",
                "4 17 153 -105",
                "485 -113 339",
                "87 -340",
                "229",
                "-137 -362 -307 -41 216 -41 -216 -116 -265",
                "-173 -109 260 42 339 185 295 108",
                "-301 489 81 280 -134 471 497",
                "-176 18 -244 500 478 -211",
                "137 404 491 -107 -264",
                "79 -85 500 27",
                "-287 -217 291",
                "346 -112",
                "2",
                "-97 247 483 -24 108 500 319 37 471 188",
                "234 500 317 -168 93 169 342 500 -277",
                "298 -332 175 500 316 265 -328 472",
                "-72 391 424 -7 358 43 500",
                "397 500 500 -222 -66 72",
                "340 231 -314 -281 437",
                "152 -48 -159 85",
                "48 500 -184",
                "286 471",
                "500"
        };

        System.out.println(Wombats21.find(createTetrahedron(argg)));

        // Wombats

        String[] arg1 = {
                "12",
                "331",
                "-127 -98",
                "-18",
                "-239 307 478",
                "-218 251",
                "256",
                "-249 -198 9 63",
                "-285 -203 -74",
                "500 205",
                "-80",
                "-53 305 -155 138 500",
                "28 -133 500 -148",
                "500 79 500",
                "460 18",
                "500",
                "500 -328 374 -303 -40 -334",
                "486 110 22 500 172",
                "-143 -142 -185 409",
                "-184 109 60",
                "8 500",
                "40",
                "384 499 500 500 85 -238 149",
                "-109 127 45 -194 -164 456",
                "500 144 470 64 291",
                "-162 -3 500 -268",
                "-108 -339 488",
                "55 -193",
                "500",
                "101 439 -28 -169 -26 -346 451 406",
                "-237 -54 500 238 29 488 421",
                "-169 376 500 338 477 239",
                "500 500 86 500 -250",
                "-216 128 -158 -61",
                "59 -20 -276",
                "68 158",
                "45",
                "70 -45 -203 180 -61 478 455 5 312",
                "-87 183 -276 -139 -132 500 138 429",
                "406 500 68 193 -299 233 73",
                "-323 500 400 -252 54 -95",
                "-170 161 -103 -336 379",
                "-127 490 180 225",
                "148 130 -245",
                "220 29",
                "-340",
                "115 500 126 500 431 500 98 169 121 500",
                "194 -203 264 -21 -112 206 157 87 141",
                "168 -188 361 -306 29 -67 190 500",
                "-275 447 -118 -268 -92 -258 -105",
                "-188 210 473 -53 416 -60",
                "500 -44 -226 -197 283",
                "10 356 477 444",
                "500 -319 293",
                "242 -277",
                "-332",
                "500 260 212 284 53 131 53 -2 -90 295 -153",
                "467 114 -168 -80 92 -320 223 -97 -170 500",
                "260 224 366 -260 104 395 70 -308 465",
                "86 251 -239 335 500 -149 -187 -29",
                "-114 -240 500 80 265 -236 -51",
                "500 203 -23 101 453 154",
                "-9 -250 -276 394 500",
                "-134 135 -55 -95",
                "500 68 194",
                "435 440",
                "112",
                "500 290 431 -135 398 80 -17 9 -119 279 -113 121",
                "293 25 -79 485 53 -292 500 -206 273 -232 -34",
                "255 -289 500 360 -58 422 147 401 92 474",
                "-132 -6 218 -14 14 264 214 331 498",
                "-318 -30 500 500 -199 -40 386 395",
                "-209 5 200 105 298 -52 -218",
                "4 237 500 188 -15 -321",
                "9 -110 21 264 223",
                "72 -125 -216 -251",
                "-281 500 -243",
                "500 491",
                "500"
        };

        System.out.println("Ex Output: 46065");
        //System.out.println("My Output: " + Wombats21.find(createTetrahedron(arg1)));

        String[] arg2 = {
                "12",
                "168",
                "243 365",
                "500",
                "344 -44 97",
                "123 342",
                "345",
                "155 132 173 45",
                "341 -109 40",
                "-279 -455",
                "-157",
                "-305 -227 234 -284 -268",
                "500 214 480 -230",
                "74 -342 397",
                "466 172",
                "80",
                "268 277 326 500 -233 129",
                "154 358 -240 348 157",
                "-200 -154 338 -195",
                "149 182 -273",
                "500 357",
                "-82",
                "211 -280 -143 440 -57 -336 -14",
                "-133 -15 500 285 -280 -1",
                "284 -363 277 -414 454",
                "497 83 -240 446",
                "79 -444 400",
                "377 197",
                "-415",
                "367 -297 -37 36 -428 -31 -375 -26",
                "-218 70 300 -84 -257 43 -215",
                "201 476 -119 -64 211 -206",
                "-419 444 -297 177 -19",
                "-282 35 -184 64",
                "-230 332 -84",
                "192 -174",
                "-53",
                "310 -400 70 241 129 -171 -385 21 21",
                "-141 371 -354 200 457 6 143 187",
                "-92 305 -178 348 172 7 313",
                "385 236 103 -240 -424 79",
                "-144 345 138 386 44",
                "417 364 -192 -104",
                "500 126 417",
                "-362 475",
                "332",
                "104 76 -333 161 500 -51 -32 160 105 -261",
                "-306 -201 -8 -87 -166 500 -82 328 126",
                "453 500 1 275 478 47 268 62",
                "-78 55 -4 -288 -383 221 -162",
                "-72 -100 -64 355 209 500",
                "243 362 448 -307 424",
                "431 -319 -199 -93",
                "-43 -288 -114",
                "417 137",
                "500",
                "-78 -137 34 303 377 179 164 144 -452 152 500",
                "-93 -454 34 -425 196 426 86 102 269 -31",
                "-8 409 -81 358 -176 -220 394 391 376",
                "365 -229 388 -453 224 -86 -125 -154",
                "207 -117 147 -114 249 153 379",
                "-27 498 -47 500 58 -320",
                "-364 199 239 -296 -294",
                "212 -57 249 61",
                "469 -238 -18",
                "5 460",
                "355",
                "378 -207 350 -267 135 -44 78 500 258 -395 -345 214",
                "18 -368 421 -153 418 79 -456 -420 -66 -94 -327",
                "-359 116 -400 -448 -444 64 471 60 -409 -277",
                "-131 -217 7 284 11 -1 0 75 -196",
                "-328 242 -105 -449 -452 463 -221 242",
                "192 -138 -394 324 -38 182 73",
                "-336 -113 287 284 407 337",
                "156 -266 269 -378 167",
                "429 -230 316 -37",
                "33 137 354",
                "78 147",
                "361"
        };

        System.out.println("Ex Output: 30984");
        //System.out.println("My Output: " + Wombats21.find(createTetrahedron(arg2)));


        // Ontology
        /*
        String[] arr = {
                "20",
                "SSZSL ( SZSSjSSSj ( S ( SSjSSSS ( SSS ( j ( SSSSSjSS ) SSSjS SSSaSS ) ) ZSS Sj SSSjSSZSS Sjj ) SSSS ( jpSjSSS ( jSjSSZSSS ( Smj ) ) ) ) SSSSS ( SSSSSSpS ) SS )",
                "20",
                "SS: SSSSSSSS",
                "ZSS: SSSSjmS",
                "SS: SSSSSSS",
                "SSSS: SSjSSSSS",
                "SZSSjSSSj: aSaZ",
                "SZSSjSSSj: S",
                "SSSjSSZSS: S",
                "SZSSjSSSj: SjSSSSS",
                "S: SSSaSSjS",
                "SSjSSSS: SZZSSSSS",
                "SSS: SSSSSSSS",
                "jSjSSZSSS: S",
                "SSSSS: SSS",
                "S: SjSSS",
                "j: SSBSSSSSS",
                "SSSjSSZSS: S",
                "SSSS: SSGSZpS",
                "SSjSSSS: SS",
                "SSSSS: SSS",
                "SSSjS: SSSj",
                "200",
                "j S",
                "SSSjSSZSS j",
                "SSSaSS S",
                "j S",
                "SSS S",
                "j S",
                "SSSSSSpS S",
                "jpSjSSS S",
                "Sjj S",
                "jSjSSZSSS Z",
                "S j",
                "SS S",
                "jpSjSSS S",
                "SZSSjSSSj S",
                "SSS S",
                "SS S",
                "SSSSS j",
                "SSjSSSS S",
                "SSSaSS a",
                "Sjj S",
                "ZSS S",
                "ZSS S",
                "Sj S",
                "SZSSjSSSj j",
                "ZSS S",
                "SSS S",
                "SSjSSSS a",
                "SSSS S",
                "SSSjSSZSS S",
                "ZSS Z",
                "SSSSSSpS S",
                "S S",
                "SSSjS j",
                "SSSSS S",
                "Sjj S",
                "Sj N",
                "Smj j",
                "jSjSSZSSS S",
                "SS S",
                "jSjSSZSSS S",
                "SSSjSSZSS S",
                "SS S",
                "SS S",
                "Sj S",
                "SS S",
                "SSSaSS S",
                "SSSjS j",
                "SSSSSSpS S",
                "jSjSSZSSS S",
                "SSS S",
                "SSSSSSpS S",
                "Sjj S",
                "SSZSL S",
                "S S",
                "SSSjSSZSS S",
                "SSSaSS S",
                "SSSS S",
                "SSSjS S",
                "j S",
                "SSSjSSZSS S",
                "jpSjSSS S",
                "SSSSSjSS S",
                "SSSSS S",
                "SSSSSSpS S",
                "SSZSL S",
                "SSSSSjSS S",
                "S Z",
                "j S",
                "SS S",
                "jSjSSZSSS S",
                "SSSaSS S",
                "ZSS S",
                "SS S",
                "SSSSSSpS S",
                "SSSSSjSS S",
                "SSS S",
                "SSSaSS S",
                "SZSSjSSSj Z",
                "Sj G",
                "SSSSSSpS S",
                "SSSSSjSS S",
                "S S",
                "SSSSS S",
                "SS S",
                "Sj S",
                "S j",
                "SSSaSS S",
                "SSSSS S",
                "SSSjS B",
                "SSjSSSS S",
                "ZSS S",
                "SSZSL j",
                "SSSSS S",
                "SSSSS S",
                "SSZSL S",
                "j S",
                "SSSaSS S",
                "SSZSL S",
                "Smj a",
                "SS S",
                "SSjSSSS S",
                "jpSjSSS S",
                "j S",
                "jSjSSZSSS j",
                "SSSaSS j",
                "SSSSSSpS j",
                "SSSSSSpS S",
                "j S",
                "ZSS S",
                "ZSS S",
                "Smj S",
                "S S",
                "S S",
                "SSSaSS j",
                "SSjSSSS S",
                "S S",
                "SSjSSSS S",
                "Sjj S",
                "SSSSS S",
                "j S",
                "S S",
                "SSSjS j",
                "SZSSjSSSj S",
                "Sj S",
                "SSSjS S",
                "SSSSS S",
                "jSjSSZSSS S",
                "SSSjSSZSS S",
                "SSSSSSpS j",
                "jSjSSZSSS S",
                "ZSS S",
                "Sj j",
                "SSSaSS S",
                "ZSS S",
                "Sj S",
                "Smj S",
                "SSZSL j",
                "Sjj S",
                "SSSS S",
                "SS S",
                "j S",
                "jSjSSZSSS S",
                "SSjSSSS j",
                "ZSS S",
                "SSZSL S",
                "SS S",
                "SSSS S",
                "Sjj S",
                "SS S",
                "SZSSjSSSj Z",
                "SSjSSSS S",
                "SSSjSSZSS S",
                "SSjSSSS S",
                "Smj S",
                "S S",
                "SS S",
                "SSSSSjSS S",
                "SZSSjSSSj S",
                "SSS S",
                "Smj S",
                "Smj S",
                "SSSSS S",
                "SSjSSSS S",
                "SSjSSSS j",
                "SZSSjSSSj S",
                "SZSSjSSSj S",
                "SSS S",
                "SSSaSS S",
                "Smj S",
                "SSSS S",
                "SSSaSS S",
                "SSZSL S",
                "SS S",
                "SSSSSSpS S",
                "SSS S",
                "SSSS S",
                "SSSjSSZSS S",
                "S S",
                "j S",
                "j j",
                "ZSS S",
                "SZSSjSSSj S",
                "S S",
                "S S",
                "SS S",
                "j S",
                "j S",
                "SSS S",
                "SSS j",
                "SSSaSS S",
                "SSjSSSS S",
                "SS S",
                "S S",
                "j S",
                "Smj S",
                "SSSSS S",
                "j S",
                "jpSjSSS S",
                "Sj S",
                "SSSSSSpS S"
        };

        String[] alpha = {
                "6",
                "Animals ( Reptiles Birds ( Eagles Pigeons Crows ) )",
                "5",
                "Reptiles: Why are many reptiles green?",
                "Birds: How do birds fly?",
                "Eagles: How endangered are eagles?",
                "Pigeons: Where in the world are pigeons most densely populated?",
                "Eagles: Where do most eagles live?",
                "4",
                "Eagles How en",
                "Birds Where",
                "Reptiles Why do",
                "Animals Wh"
        };
        Ontology.find(alpha);
        */
    }


    public static Tetrahedron[][] createTetrahedron(String[] arg) {
        int levels = Integer.parseInt(arg[0]);
        Wombats.levels = levels;
        Wombats21.levels = levels;
        if (levels == 0) {
            return null;
        }
        Tetrahedron[][] arr = new Tetrahedron[arg.length][];
        arr[0] = new Tetrahedron[1];
        arr[0][0] = new Tetrahedron(Integer.parseInt(arg[1]));
        for (int i = 1; i < levels; i++) {
            int y = 0;
            for (int j = (i * (i + 1) / 2) + 1; j < (i * (i + 1) / 2) + 1 + i + 1; j++) {
                ArrayList<Tetrahedron> levelList = new ArrayList();
                int x = 0;
                String[] argArr = arg[j].split(" ");
                for (String s : argArr) {
                    Tetrahedron a = new Tetrahedron(Integer.parseInt(s));
                    levelList.add(x, a);
                    if (x == 0) {
                        if (y == 0) {
                            arr[(i * (i - 1) / 2) + y][x].addChildren(a);
                            a.addParent(arr[(i * (i - 1) / 2) + y][x]);
                        } else {
                            if ((i * (i + 1) / 2) + y + 1 == ((i + 2) * (i + 1) / 2)) {
                                arr[(i * (i - 1) / 2) + y - 1][x].addChildren(a);
                                a.addParent(arr[(i * (i - 1) / 2) + y - 1][x]);
                            } else {
                                arr[(i * (i - 1) / 2) + y][x].addChildren(a);
                                a.addParent(arr[(i * (i - 1) / 2) + y][x]);
                                arr[(i * (i - 1) / 2) + y - 1][x].addChildren(a);
                                a.addParent(arr[(i * (i - 1) / 2) + y - 1][x]);
                            }
                        }
                    } else {
                        if (x == argArr.length - 1) {
                            if (y == 0) {
                                arr[(i * (i - 1) / 2) + y][x - 1].addChildren(a);
                                a.addParent(arr[(i * (i - 1) / 2) + y][x - 1]);
                            } else {
                                if ((i * (i + 1) / 2) + y + 1 == ((i + 2) * (i + 1) / 2)) {
                                    arr[(i * (i - 1) / 2) + y - 1][x - 1].addChildren(a);
                                    a.addParent(arr[(i * (i - 1) / 2) + y - 1][x - 1]);
                                } else {
                                    arr[(i * (i - 1) / 2) + y][x - 1].addChildren(a);
                                    a.addParent(arr[(i * (i - 1) / 2) + y][x - 1]);
                                    arr[(i * (i - 1) / 2) + y - 1][x].addChildren(a);
                                    a.addParent(arr[(i * (i - 1) / 2) + y - 1][x]);
                                }
                            }
                        } else {
                            if (y == 0) {
                                arr[(i * (i - 1) / 2) + y][x].addChildren(a);
                                a.addParent(arr[(i * (i - 1) / 2) + y][x]);

                                arr[(i * (i - 1) / 2) + y][x - 1].addChildren(a);
                                a.addParent(arr[(i * (i - 1) / 2) + y][x - 1]);
                            } else {
                                if ((i * (i + 1) / 2) + y + 1 == ((i + 2) * (i + 1) / 2)) {
                                    arr[(i * (i - 1) / 2) + y - 1][x].addChildren(a);
                                    a.addParent(arr[(i * (i - 1) / 2) + y - 1][x]);

                                    arr[(i * (i - 1) / 2) + y - 1][x - 1].addChildren(a);
                                    a.addParent(arr[(i * (i - 1) / 2) + y - 1][x - 1]);
                                } else {
                                    arr[(i * (i - 1) / 2) + y][x].addChildren(a);
                                    a.addParent(arr[(i * (i - 1) / 2) + y][x]);

                                    arr[(i * (i - 1) / 2) + y][x - 1].addChildren(a);
                                    a.addParent(arr[(i * (i - 1) / 2) + y][x - 1]);

                                    arr[(i * (i - 1) / 2) + y - 1][x].addChildren(a);
                                    a.addParent(arr[(i * (i - 1) / 2) + y - 1][x]);

                                    arr[(i * (i - 1) / 2) + y - 1][x - 1].addChildren(a);
                                    a.addParent(arr[(i * (i - 1) / 2) + y - 1][x - 1]);
                                }
                            }
                        }
                    }
                    x++;
                }
                arr[j - 1] = new Tetrahedron[levelList.size()];
                arr[j - 1] = levelList.toArray(arr[j - 1]);
                y++;
            }
        }
        return arr;
    }

    public static void setParents(Tetrahedron root) {
        if (root == null)
            return;
        for (Tetrahedron c : root.children) {
            if (c == null)
                continue;
            if (c.parents[0] == null) {
                c.parents[0] = root;
            } else {
                if (c.parents[1] == null) {
                    c.parents[1] = root;
                } else {
                    if (c.parents[2] == null) {
                        c.parents[2] = root;
                    }
                }
            }
            setParents(c);
        }
    }
}
