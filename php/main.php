<?php
function checkIn($x, $y, $r)
{
    if ($x >= 0 and $y >= 0) {
        return $x <= $r and 2 * ($x + $y) <= $r;
    }
    if ($x >= 0 and $y < 0) {
        return $x <= $r and 2 * $y >= -$r;
    }
    return $y <= 0 and $x * $x + $y * $y <= $r;
}

$x = (int) $_POST['x'];
$y = (int) $_POST['y'];
$r = (int) $_POST['r'];
$timezoneOffset = $_POST['timezone'];

$start = date("H:i:s", time() - $timezoneOffset * 60);
$time_start = microtime(true);

$xMin = -4;
$xMax = 4;
$yMin = -3;
$yMax = 5;
$rMin = 1;
$rMax = 5;

if(!($xMin <= $x and $x <= $xMax)){
    header('HTTP/1.1 401 Bad Request', true, 401);
    return;
}

if(!($yMin <= $y and $y <= $yMax)){
    header('HTTP/1.1 401 Bad Request', true, 401);
    return;
}

if(!($rMin <= $r and $r <= $rMax)){
    header('HTTP/1.1 401 Bad Request', true, 401);
    return;
}

$result = checkIn($x, $y, $r) ? "Попадание" : "Промах";
$time_end = microtime(true);
$execution_time = ($time_end - $time_start);
$execution_time_short = intval($execution_time * ($p = pow(10, 3))) / $p;
echo json_encode(
    array(
        'cords' => array($x, $y, $r),
        'time' => $start,
        'exec' => $execution_time_short,
        'result' => $result
    )
);
?>