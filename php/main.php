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

$x = $_POST['x'];
$y = $_POST['y'];
$r = $_POST['r'];
$timezoneOffset = $_POST['timezone'];

$start = date("H:i:s", time() - $timezoneOffset * 60);
$time_start = microtime(true);
$result = checkIn($x, $y, $r) ? "Попадание" : "Промах";
$time_end = microtime(true);
$execution_time = ($time_end - $time_start);
echo json_encode(
    array(
        'cords' => array($x, $y, $r),
        'time' => $start,
        'exec' => $execution_time,
        'result' => $result
    )
);
?>