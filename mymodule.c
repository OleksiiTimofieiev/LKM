#include <linux/module.h>
#include <linux/init.h>

/* meta information */
MODULE_LICENSE("GPL");
MODULE_AUTHOR("otimofie");
MODULE_DESCRIPTION("Hello world LKM");

static int __init ModuleInit(void) {
    printk("Init from LKM\n");
    return 0;
}

static void __exit ModuleExit(void) {
    printk("Exit from LKM\n");
}

module_init(ModuleInit);
module_exit(ModuleExit);

