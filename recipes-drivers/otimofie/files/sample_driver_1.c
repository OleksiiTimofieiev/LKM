#include <linux/module.h>
#include <linux/fs.h>
#include <linux/init.h>

#define MYMAJOR 64

static int driver_open(struct inode *device_file, struct  file *instance) {
    printk("[driver] OPEN\n");
    return 0;
}

static int driver_close(struct inode *device_file, struct  file *instance) {
    printk("[driver] CLOSE\n");
    return 0;
}

static struct file_operations fops = {
	.owner = THIS_MODULE,
	.open = driver_open,
	.release = driver_close
};

static int __init mydriver_init(void) {
    int retval;

    printk("[driver] INIT \n");

	/* register device nr. */
	retval = register_chrdev(MYMAJOR, "my_dev_nr", &fops);
	if(retval == 0) {
		printk("[driver] dev_nr - registered Device number Major: %d, Minor: %d\n", MYMAJOR, 0);
	}
	else if(retval > 0) {
		printk("[driver] dev_nr - registered Device number Major: %d, Minor: %d\n", retval>>20, retval&0xfffff);
	}
	else {
		printk("[driver] Could not register device number!\n");
		return -1;
	}
	return 0;
}

static void __exit mydriver_exit(void) {
    unregister_chrdev(MYMAJOR, "my_dev_nr");
    printk("[driver] EXIT \n");
}

module_init(mydriver_init);
module_exit(mydriver_exit);


MODULE_LICENSE("GPL");
MODULE_AUTHOR("otimofie");
MODULE_DESCRIPTION("Yocto driver test");
MODULE_VERSION("1.0");