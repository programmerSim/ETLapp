package com.data.etldata.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExtractContentDto {

    @CsvBindByPosition(position = 0)
    @CsvBindByName(column = "time")
    private Timestamp minTime;

    @CsvBindByPosition(position = 1)
    @CsvBindByName(column = "resourceName")
    private String resourceName;

    @CsvBindByPosition(position = 2)
    @CsvBindByName(column = "basic_ping.average_response_ms")
    private float basic_ping_average_response_ms;

    @CsvBindByPosition(position = 3)
    @CsvBindByName(column = "basic_ping.maximum_response_ms")
    private float basic_ping_maximum_response_ms;

    @CsvBindByPosition(position = 4)
    @CsvBindByName(column = "basic_ping.minimum_response_ms")
    private float basic_ping_minimum_response_ms;

    @CsvBindByPosition(position = 5)
    @CsvBindByName(column = "basic_ping.packets_received")
    private float basic_ping_packets_received;

    @CsvBindByPosition(position = 6)
    @CsvBindByName(column = "basic_ping.packets_transmitted")
    private float basic_ping_packets_transmitted;

    @CsvBindByPosition(position = 7)
    @CsvBindByName(column = "basic_ping.percent_packet_loss")
    private float basic_ping_percent_packet_loss;

    @CsvBindByPosition(position = 8)
    @CsvBindByName(column = "basic_ping.result_code")
    private float basic_ping_result_code;

    @CsvBindByPosition(position = 9)
    @CsvBindByName(column = "basic_ping.standard_deviation_ms")
    private float basic_ping_standard_deviation_ms;

    @CsvBindByPosition(position = 10)
    @CsvBindByName(column = "bond.status")
    private float bond_status;

    @CsvBindByPosition(position = 11)
    @CsvBindByName(column = "bond_slave.failures")
    private float bond_slave_failures;

    @CsvBindByPosition(position = 12)
    @CsvBindByName(column = "bond_slave.status")
    private float bond_slave_status;

    @CsvBindByPosition(position = 13)
    @CsvBindByName(column = "command_time.df_result")
    private float command_time_df_result;

    @CsvBindByPosition(position = 14)
    @CsvBindByName(column = "command_time.df_time")
    private float command_time_df_time;

    @CsvBindByPosition(position = 15)
    @CsvBindByName(column = "command_time.ls_result")
    private float command_time_ls_result;

    @CsvBindByPosition(position = 16)
    @CsvBindByName(column = "command_time.ls_time")
    private float command_time_ls_time;

    @CsvBindByPosition(position = 17)
    @CsvBindByName(column = "command_time.sar_result")
    private float command_time_sar_result;

    @CsvBindByPosition(position = 18)
    @CsvBindByName(column = "command_time.sar_time")
    private float command_time_sar_time;

    @CsvBindByPosition(position = 19)
    @CsvBindByName(column = "command_time.top_result")
    private float command_time_top_result;

    @CsvBindByPosition(position = 20)
    @CsvBindByName(column = "command_time.top_time")
    private float command_time_top_time;

    @CsvBindByPosition(position = 21)
    @CsvBindByName(column = "command_time.touch_result")
    private float command_time_touch_result;

    @CsvBindByPosition(position = 22)
    @CsvBindByName(column = "command_time.touch_time")
    private float command_time_touch_time;

    @CsvBindByPosition(position = 23)
    @CsvBindByName(column = "cpu.queue_perc")
    private float cpu_queue_perc;

    @CsvBindByPosition(position = 24)
    @CsvBindByName(column = "cpu.usage_active")
    private float cpu_usage_active;

    @CsvBindByPosition(position = 25)
    @CsvBindByName(column = "cpu.usage_guest")
    private float cpu_usage_guest;

    @CsvBindByPosition(position = 26)
    @CsvBindByName(column = "cpu.usage_guest_nice")
    private float cpu_usage_guest_nice;

    @CsvBindByPosition(position = 27)
    @CsvBindByName(column = "cpu.usage_idle")
    private float cpu_usage_idle;

    @CsvBindByPosition(position = 28)
    @CsvBindByName(column = "cpu.usage_iowait")
    private float cpu_usage_iowait;

    @CsvBindByPosition(position = 29)
    @CsvBindByName(column = "cpu.usage_irq")
    private float cpu_usage_irq;

    @CsvBindByPosition(position = 30)
    @CsvBindByName(column = "cpu.usage_nice")
    private float cpu_usage_nice;

    @CsvBindByPosition(position = 31)
    @CsvBindByName(column = "cpu.usage_perc")
    private float cpu_usage_perc;

    @CsvBindByPosition(position = 32)
    @CsvBindByName(column = "cpu.usage_softirq")
    private float cpu_usage_softirq;

    @CsvBindByPosition(position = 33)
    @CsvBindByName(column = "cpu.usage_steal")
    private float cpu_usage_steal;

    @CsvBindByPosition(position = 34)
    @CsvBindByName(column = "cpu.usage_system")
    private float cpu_usage_system;

    @CsvBindByPosition(position = 35)
    @CsvBindByName(column = "cpu.usage_user")
    private float cpu_usage_user;

    // private float daemon_status;

    @CsvBindByPosition(position = 36)
    @CsvBindByName(column = "disk.free")
    private float disk_free;

    @CsvBindByPosition(position = 37)
    @CsvBindByName(column = "disk.inodes_free")
    private float disk_inodes_free;

    @CsvBindByPosition(position = 38)
    @CsvBindByName(column = "disk.inodes_total")
    private float disk_inodes_total;

    @CsvBindByPosition(position = 39)
    @CsvBindByName(column = "disk.inodes_used")
    private float disk_inodes_used;

    @CsvBindByPosition(position = 40)
    @CsvBindByName(column = "isk.inodes_used_perc")
    private float disk_inodes_used_perc;

    @CsvBindByPosition(position = 41)
    @CsvBindByName(column = "disk.mode_code")
    private float disk_mode_code;

    @CsvBindByPosition(position = 42)
    @CsvBindByName(column = "disk.total")
    private float disk_total;

    @CsvBindByPosition(position = 43)
    @CsvBindByName(column = "disk.used")
    private float disk_used;

    @CsvBindByPosition(position = 44)
    @CsvBindByName(column = "disk.used_percent")
    private float disk_used_percent;

    @CsvBindByPosition(position = 45)
    @CsvBindByName(column = "diskio.io_avgqu_sz")
    private float diskio_io_avgqu_sz;

    @CsvBindByPosition(position = 46)
    @CsvBindByName(column = "diskio.io_await")
    private float diskio_io_await;

    @CsvBindByPosition(position = 47)
    @CsvBindByName(column = "diskio.io_cpu_perc")
    private float diskio_io_cpu_perc;

    @CsvBindByPosition(position = 48)
    @CsvBindByName(column = "diskio.io_svctm")
    private float diskio_io_svctm;

    @CsvBindByPosition(position = 49)
    @CsvBindByName(column = "diskio.io_time")
    private float diskio_io_time;

    @CsvBindByPosition(position = 50)
    @CsvBindByName(column = "diskio.io_util")
    private float diskio_io_util;

    @CsvBindByPosition(position = 51)
    @CsvBindByName(column = "diskio.iops_in_progress")
    private float diskio_iops_in_progress;

    @CsvBindByPosition(position = 52)
    @CsvBindByName(column = "diskio.reads")
    private float diskio_reads;

    @CsvBindByPosition(position = 53)
    @CsvBindByName(column = "diskio.read_bytes")
    private float diskio_read_bytes;

    @CsvBindByPosition(position = 54)
    @CsvBindByName(column = "diskio.read_bytes_sec")
    private float diskio_read_bytes_sec;

    @CsvBindByPosition(position = 55)
    @CsvBindByName(column = "diskio.read_req_sec")
    private float diskio_read_req_sec;

    @CsvBindByPosition(position = 56)
    @CsvBindByName(column = "diskio.read_time")
    private float diskio_read_time;

    @CsvBindByPosition(position = 57)
    @CsvBindByName(column = "diskio.read_time_sec")
    private float diskio_read_time_sec;

    @CsvBindByPosition(position = 58)
    @CsvBindByName(column = "diskio.weighted_io_time")
    private float diskio_weighted_io_time;

    @CsvBindByPosition(position = 59)
    @CsvBindByName(column = "diskio.writes")
    private float diskio_writes;

    @CsvBindByPosition(position = 60)
    @CsvBindByName(column = "diskio.write_bytes")
    private float diskio_write_bytes;

    @CsvBindByPosition(position = 61)
    @CsvBindByName(column = "diskio.write_bytes_sec")
    private float diskio_write_bytes_sec;

    @CsvBindByPosition(position = 62)
    @CsvBindByName(column = "diskio.write_req_sec")
    private float diskio_write_req_sec;

    @CsvBindByPosition(position = 63)
    @CsvBindByName(column = "diskio.write_time")
    private float diskio_write_time;

    @CsvBindByPosition(position = 64)
    @CsvBindByName(column = "diskio.write_time_sec")
    private float diskio_write_time_sec;

    @CsvBindByPosition(position = 65)
    @CsvBindByName(column = "disk_mount.status")
    private float disk_mount_status;
}
