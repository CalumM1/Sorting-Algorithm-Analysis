import csv
import matplotlib.pyplot as plt

with open("runtimes2.csv") as file:
    reader = csv.reader(file)

    input_sizes = next(reader)
    input_sizes = [int(val) for val in input_sizes]
    
    insertion_sort = next(reader)
    selection_sort = next(reader)
    shell_sort = next(reader)
    merge_sort = next(reader)
    merge_insertion_sort = next(reader)
    bottom_up_merge_sort = next(reader)
    quick_sort = next(reader)
    quick_median3_sort = next(reader)
    quick_dutch_flag_sort = next(reader)
    quick_insertion_sort = next(reader)
    
    insertion_sort = [int(val) for val in insertion_sort]
    selection_sort = [int(val) for val in selection_sort]
    shell_sort = [int(val) for val in shell_sort]
    merge_sort = [int(val) for val in merge_sort]
    merge_insertion_sort = [int(val) for val in merge_insertion_sort]
    bottom_up_merge_sort = [int(val) for val in bottom_up_merge_sort]
    quick_sort = [int(val) for val in quick_sort]
    quick_median3_sort = [int(val) for val in quick_median3_sort]
    quick_dutch_flag_sort = [int(val) for val in quick_dutch_flag_sort]
    quick_insertion_sort = [int(val) for val in quick_insertion_sort]
    
    # plt.plot(input_sizes, insertion_sort, label="Insertion Sort", linestyle='-', color='b')
    # plt.plot(input_sizes, selection_sort, label="Selection Sort", linestyle='-', color='g')
    plt.plot(input_sizes, shell_sort, label="Shell Sort", linestyle='-', color='r')
    plt.plot(input_sizes, merge_sort, label="Merge Sort", linestyle='-', color='c')
    plt.plot(input_sizes, merge_insertion_sort, label="Merge + Insertion Sort", linestyle='-', color='m')
    plt.plot(input_sizes, bottom_up_merge_sort, label="Bottom-Up Merge Sort", linestyle='-', color='y')
    plt.plot(input_sizes, quick_sort, label="Quick Sort", linestyle='-', color='k')
    plt.plot(input_sizes, quick_median3_sort, label="Quick Median3 Sort", linestyle='--', color='b')
    plt.plot(input_sizes, quick_dutch_flag_sort, label="Quick Dutch Flag Sort", linestyle='--', color='g')
    plt.plot(input_sizes, quick_insertion_sort, label="Quick Insertion Sort", linestyle='--', color='r')
    
    plt.xscale('log')  
    plt.yscale('log') 
    
    plt.xticks([10, 50, 100, 1000, 20000, 500000, 1000000])

    plt.xlim(min(input_sizes), max(input_sizes))
    
    # plt.ylim(min(min(insertion_sort), min(selection_sort), min(shell_sort), min(merge_sort), min(merge_insertion_sort), min(bottom_up_merge_sort), min(quick_sort), min(quick_median3_sort), min(quick_dutch_flag_sort), min(quick_insertion_sort)),
            #  max(max(insertion_sort), max(selection_sort), max(shell_sort), max(merge_sort), max(merge_insertion_sort), max(bottom_up_merge_sort), max(quick_sort), max(quick_median3_sort), max(quick_dutch_flag_sort), max(quick_insertion_sort)))
    
    plt.ylim(min(min(shell_sort), min(merge_sort), min(merge_insertion_sort), min(bottom_up_merge_sort), min(quick_sort), min(quick_median3_sort), min(quick_dutch_flag_sort), min(quick_insertion_sort)),
             max(max(shell_sort), max(merge_sort), max(merge_insertion_sort), max(bottom_up_merge_sort), max(quick_sort), max(quick_median3_sort), max(quick_dutch_flag_sort), max(quick_insertion_sort)))
    
    plt.xlabel("Input Size")
    plt.ylabel("Running Time in Nanoseconds (Log scale)")
    plt.title("Comparison of O(nlogn) Algorithms")
    plt.legend()
    
    plt.savefig("plots/nlogn.png")
    
    plt.show()
